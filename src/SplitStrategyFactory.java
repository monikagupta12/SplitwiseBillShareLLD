public class SplitStrategyFactory {
    public static SplitStrategy getSplitStrategy(SplitType splitType){
        if (splitType.equals(SplitType.EQUAL)){
            return new EqualSplitStrategy();
        }
        else if(splitType.equals(SplitType.UNEQUAL)){
            return new UnequalSplitStrategy();
        }
        else{
            return new PercentageSplitStrategy();
        }
    }
}
