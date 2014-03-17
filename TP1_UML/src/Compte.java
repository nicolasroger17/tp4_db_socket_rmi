public abstract class Compte {

    protected double tauxInteret;
    protected double sold;

    public Compte (double tauxInteret, double sold) {
        this.tauxInteret = tauxInteret;
        this.sold = sold;
    }

    public void setSold (int val) {
        this.sold = val;
    }
    
    public void getSold(){
        System.out.println("Le solde de votre Compte de "+this.sold);
    }

    public void addCredit (double val) throws AmountMaximumException{
        this.sold += val;
        System.out.println("Vous avez crédité votre compte de : "+val);
    }

}