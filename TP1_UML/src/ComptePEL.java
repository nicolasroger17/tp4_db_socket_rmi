public class ComptePEL extends Compte {

    private final double MIN_CAP = 10000;

    public ComptePEL (double tauxInteret, double sold) {
        super(0,0);
        if(sold > MIN_CAP){
            this.tauxInteret = tauxInteret;
            this.sold = sold;
        }
    }
    
    public double retreat (double debit) throws Exception{
        if((this.sold - debit) > MIN_CAP){            
            this.sold -= debit;
            System.out.println("Vous avez débité : "+debit);
            return debit;
        }
        else{
            throw new AmountMinimumException(debit, MIN_CAP, sold);
        }
    }

    @Override
    public void getSold () {
        System.out.println("Le solde de votre PEL est de "+this.sold);
    }

}