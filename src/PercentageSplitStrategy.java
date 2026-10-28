import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> getSplit(List<User> users, SplitAmountMetaData shareSplit, double totaAmount) {
        Map<String,Double> precentageMap=shareSplit.getPercentage();
        double sum=precentageMap.values().stream().mapToDouble(Double::doubleValue).sum();
        if(sum!=100.0){
            throw  new RuntimeException("total percentage not 100");
        }
        List<Split> shareList=new ArrayList<>();
        double perPersonAmount;
        for (User user:users){
            double share=totaAmount*precentageMap.get(user.getUserId())/100;
            Split split=new Split(user.getUserId(), share);
            shareList.add(split);
        }
        return shareList;
    }
}
