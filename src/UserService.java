import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UserService {
    UserHandler userHandler;
    ExpanseHandler expanseHandler;
    GroupHandler groupHandler;

    public UserService(UserHandler userHandler, ExpanseHandler expanseHandler,GroupHandler groupHandler) {
        this.userHandler = userHandler;
        this.expanseHandler = expanseHandler;
        this.groupHandler=groupHandler;
    }

    public String createGroup(String groupName, Set<String> members){
        Group group=new Group(groupName);
        for (String phoneNo:members){
            User user=userHandler.getUser(phoneNo);
            group.getMembers().add(user);
            user.getGroupList().add(group.getGroupId());
        }
        groupHandler.addewGroup(group);
        return group.getGroupId();
    }

    public void addNewMemberInGroup(Group group,User user){
        group.addNewMember(user);
        user.getGroupList().add(group.getGroupId());
    }

    public String createExpanse(String description, String paidUser,
                                List<String> users, SplitType splitType, double totalAmount,
                                HashMap<String,Double> metaData){
        List<User> userList=users.stream().map(u->userHandler.getUser(u)).toList();
        SplitStrategy splitStrategy= SplitStrategyFactory.getSplitStrategy(splitType);
        List<Split> split=null;
        if(splitType.equals(SplitType.EQUAL)){
             split=splitStrategy.getSplit(userList,null,totalAmount);
        }
        else{
           SplitAmountMetaData sharePart= getSharePartation(splitType,metaData);
            split=splitStrategy.getSplit(userList,sharePart,totalAmount);
        }
        User user=userHandler.getUser(paidUser);
        updateBalanceSheet(split,metaData,user,user.getBalanceSheet());
        Expanse expanse= new Expanse.ExpanseBuilder().
                setDescription(description).
                setSplitType(splitType).
                setTotalAmount(totalAmount).
                setPaidBy(user).
                setParticipants(split).
                build();

        expanseHandler.addExpanse(expanse);
        return expanse.getExpanseId();
    }


    public void showUserBalanceSheet(String userId){
        User user=userHandler.getUser(userId);
        user.getBalanceSheet().showBalanceSheet();
    }

    private void updateBalanceSheet(List<Split> split, HashMap<String, Double> metaData,
                                    User paidBy,BalanceSheet balanceSheet) {
        double sum=split.stream().map(split1 -> split1.getAmount()).mapToDouble(Double::doubleValue).sum();
        balanceSheet.setTotalPaid(balanceSheet.getTotalPaid()+sum);
        for (Split split1:split){
            User user=userHandler.getUser(split1.getUserId());
            BalanceSheet otherBalanceSheet =user.getBalanceSheet();
            balanceSheet.setTotalExpanse(balanceSheet.getTotalExpanse()+split1.getAmount());
            if (user.getUserId().equalsIgnoreCase(paidBy.getUserId())){
                balanceSheet.getBalances().putIfAbsent(user,0.0);
                otherBalanceSheet.getBalances().putIfAbsent(paidBy,0.0);
                double owe=balanceSheet.getBalances().get(user);
                balanceSheet.getBalances().put(user,owe+split1.getAmount());
                double amount= otherBalanceSheet.getBalances().get(paidBy);
                otherBalanceSheet.getBalances().put(paidBy,amount-1*split1.getAmount());
            }
        }

    }

    private SplitAmountMetaData getSharePartation(SplitType splitType, HashMap<String, Double> metaData) {
        if (splitType.equals(SplitType.UNEQUAL)) {
            return new SplitAmountMetaData.SplitAmountMetaDataBuilder().setUnequal(metaData).build();
        }
        else {
           return new SplitAmountMetaData.SplitAmountMetaDataBuilder().setPercentage(metaData).build();
        }
    }
}
