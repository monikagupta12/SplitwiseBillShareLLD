import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    public EqualSplitStrategy() {

    }


    @Override
    public List<Split> getSplit(List<User> users, SplitAmountMetaData shareSplit, double totaAmount) {
        List<Split> shareList=new ArrayList<>();
        int count=users.size();
        double perPersonAmount;
        for (User user:users){
            double share=totaAmount/count;
            Split split=new Split(user.getUserId(), share);
            shareList.add(split);
        }
        return shareList;
  }
}
