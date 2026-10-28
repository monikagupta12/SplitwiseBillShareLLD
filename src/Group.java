import java.util.*;

public class Group {
    private String groupId;
    private String groupName;
    private Set<User> members;
    List<Expanse> expanseList;
    private Map<User,BalanceSheet> balanceSheetMap;

    public Group(String groupName) {
        this.groupId = UUID.randomUUID().toString().substring(0,8);
        this.groupName = groupName;
        balanceSheetMap=new HashMap<>();
        expanseList=new ArrayList<>();
    }

    public Group(String groupName, Set<User> members) {
        this.groupId = UUID.randomUUID().toString().substring(0,8);
        this.groupName = groupName;
        this.members = members;
        balanceSheetMap=new HashMap<>();
    }
    public void addNewMember(User user){
        members.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public Set<User> getMembers() {
        return members;
    }

    public Map<User, BalanceSheet> getBalanceSheetMap() {
        return balanceSheetMap;
    }
}
