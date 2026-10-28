import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupHandler {
    Map<String,Group> groupMap;
    public GroupHandler() {
        groupMap =new HashMap<>();
    }


    public void addewGroup(Group group) {
        groupMap.putIfAbsent(group.getGroupId(),group);
    }
}
