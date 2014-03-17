
public class Transaction {

    protected final String reason;
    private final double value;
    private final boolean isRetreat;
    private final double sold;

    public Transaction (double value, boolean isRetreat, String reason, double sold) {
        this.value = value;
        this.isRetreat = isRetreat;
        this.reason = reason;
        this.sold = sold;       
    }

    protected void displayTransaction () {
        System.out.println(reason+" ----------------"+(isRetreat?"- -":"-- ")+value+" ------------------- "+sold);
    } 

}