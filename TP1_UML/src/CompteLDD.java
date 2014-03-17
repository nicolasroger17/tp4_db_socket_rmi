public class CompteLDD extends Compte {

    private static final int MAX_CAP = 12000;

    public CompteLDD (double tauxInteret, double sold) {
        super(0,0);
        if(sold < MAX_CAP){
            this.tauxInteret = tauxInteret;
            this.sold = sold;
        }
    }
    
    @Override
    public void getSold () {
        System.out.println("Le solde de votre LDD est de "+this.sold);
    }

    public void addCredit(double val) throws AmountMaximumException {
        
        if(val + sold < MAX_CAP){
            super.addCredit(val);
        }
        else{
            throw new AmountMaximumException(val, MAX_CAP, sold);
        }
    
    }

}