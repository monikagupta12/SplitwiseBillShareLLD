import java.util.Map;

public class SplitAmountMetaData {
    private Map<String, Double> percentage;
    private Map<String, Double> unequal;

    private SplitAmountMetaData(SplitAmountMetaDataBuilder builder) {
        this.percentage=builder.percentage;
        this.unequal=builder.unequal;
    }
    public static class SplitAmountMetaDataBuilder{
        private Map<String, Double> percentage;
        private Map<String, Double> unequal;

        public SplitAmountMetaDataBuilder() {
        }

        public SplitAmountMetaDataBuilder setPercentage(Map<String, Double> percentage) {
            this.percentage = percentage;
            return this;
        }

        public SplitAmountMetaDataBuilder setUnequal(Map<String, Double> unequal) {
            this.unequal = unequal;
            return this;
        }

        public SplitAmountMetaData build(){
            return new SplitAmountMetaData(this);
        }
        public SplitAmountMetaDataBuilder getBuilder(){
            return new SplitAmountMetaDataBuilder();
        }
    }

    public Map<String, Double> getPercentage() {
        return percentage;
    }

    public Map<String, Double> getUnequal() {
        return unequal;
    }
}
