import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private double totalPaid;
    private double totalExpanse;
    private Map<User,Double> balances;

    public BalanceSheet() {
        this.totalPaid=0.0;
        this.totalExpanse=0.0;
        this.balances =new HashMap<>();
    }
    public void showBalanceSheet(){
        System.out.println("TotalPaid amount  ="+ totalPaid);
        System.out.println("TotalExpanse="+ totalExpanse);
        for (User user: balances.keySet()){
            double amount= balances.get(user);
            if(amount>0){
                System.out.println(user.getName()+" paid amount to me "+amount);
            }
            else {
                System.out.println(user.getName()+" got amount to me "+-1*amount);
            }
        }
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getTotalExpanse() {
        return totalExpanse;
    }

    public void setTotalExpanse(double totalExpanse) {
        this.totalExpanse = totalExpanse;
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Double> balances) {
        this.balances = balances;
    }
}
