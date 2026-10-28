import java.util.List;
import java.util.UUID;

public class Expanse {
    private String expanseId;
    private String description;
    private User paidBy;
    private double totalAmount;
    private List<Split> participants;
    private SplitType splitType;

    public Expanse( ExpanseBuilder builder){
        this.expanseId= UUID.randomUUID().toString();
        this.description= builder.description;
        this.paidBy=builder.paidBy;
        this.totalAmount=builder.totalAmount;
        this.participants=builder.participants;
        this.splitType=builder.splitType;
    }

    public static class ExpanseBuilder{

        private String description;
        private User paidBy;
        private double totalAmount;
        private List<Split> participants;
        private SplitType splitType;


        public ExpanseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ExpanseBuilder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public ExpanseBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public ExpanseBuilder setParticipants(List<Split> participants) {
            this.participants = participants;
            return this;
        }

        public ExpanseBuilder setSplitType(SplitType splitType) {
            this.splitType = splitType;
            return this;
        }

        public ExpanseBuilder() {
        }

        public Expanse build() {
            return new Expanse(this);
        }
        public ExpanseBuilder getExpanseBuilder(){
            return new ExpanseBuilder();
        }
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public String getExpanseId() {
        return expanseId;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getParticipants() {
        return participants;
    }

    public SplitType getSplitType() {
        return splitType;
    }
}
