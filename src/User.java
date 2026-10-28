import java.util.ArrayList;
import java.util.List;

public class  User {
    private String userId;
    private String name;
    private BalanceSheet balanceSheet;
    private List<String> groupList;

    public User(String phoneNo, String name) {
        this.userId = phoneNo;
        this.name = name;
        this.balanceSheet=new BalanceSheet();
        groupList=new ArrayList<>();
    }

    public List<String> getGroupList() {
        return groupList;
    }


    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }
}
