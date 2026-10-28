import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SplitWise {
    GroupHandler groupHandler;
    ExpanseHandler expanseHandler;
    UserHandler userHandler;
    UserService userService;

    public SplitWise() {

        this.expanseHandler = new ExpanseHandler();
        this.userHandler = new UserHandler();
        this.groupHandler = new GroupHandler();
        userService=new UserService(userHandler,expanseHandler,groupHandler);
    }

    public String addNewUser(String name, String phoneNo){
        User user=new User(phoneNo,name);
        userHandler.addUser(user);
        return phoneNo;
    }


}
