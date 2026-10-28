import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public  class UnequalSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> getSplit(List<User> users, SplitAmountMetaData shareSplit, double totaAmount) {
        Map<String,Double>unequalMap=shareSplit.getUnequal();
        double sum=unequalMap.values().stream().mapToDouble(Double::doubleValue).sum();
        if(Math.abs(sum-totaAmount)>1){
            throw  new RuntimeException("totalAmount not equal to sum of amount, mathmatical error");
        }
        List<Split> shareList=new ArrayList<>();

        for (User user:users){
            double share=unequalMap.get(user.getUserId());
            Split split=new Split(user.getUserId(), share);
            shareList.add(split);
        }
        return shareList;
    }
}
