public class Split {
    private String userId;
    private double amount;

    public Split(String userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getUserId() {
        return userId;
    }
}
