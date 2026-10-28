import java.util.HashMap;
import java.util.Map;

public class UserHandler {
    Map<String,User> userMap;
    UserHandler(){
        userMap=new HashMap<>();
    }
    public User getUser(String phoneNo){
        if (userMap.containsKey(phoneNo)){
            return userMap.get(phoneNo);
        }
        throw new RuntimeException("user Not Exit");
    }


    public void addUser(User user) {
        if (userMap.containsKey(user.getUserId())){
            throw new RuntimeException("user Already register with this no");
        }
        userMap.put(user.getUserId(), user);
    }
}
