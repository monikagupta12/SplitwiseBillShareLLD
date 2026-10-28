import java.util.HashMap;
import java.util.Map;

public class ExpanseHandler {
    Map<String,Expanse>expanseMap;
    public ExpanseHandler() {
        expanseMap=new HashMap<>();
    }
    public void addExpanse(Expanse expanse){
        expanseMap.put(expanse.getExpanseId(),expanse);
    }

}
