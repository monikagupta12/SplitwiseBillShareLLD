import java.util.List;

public interface SplitStrategy {

    public List<Split>getSplit(List<User> user, SplitAmountMetaData shareSplit, double totaAmount);
}
