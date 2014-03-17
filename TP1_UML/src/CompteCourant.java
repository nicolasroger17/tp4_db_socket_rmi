
import java.util.ArrayList;

public class CompteCourant extends Compte {

    protected ArrayList<Transaction> transactions = new ArrayList();

    public CompteCourant (double tauxInteret, double sold) {
        super(tauxInteret, sold);        
    }

    public double retreat (double debit, String reason) throws Exception{
        if(this.sold > debit){
            this.sold -= debit;
            System.out.println("Vous avez débité : "+debit);
            setTransaction(new Transaction(debit, true, reason, this.sold));
            return debit;
        }
        else{
            throw new AmountMinimumException(debit, 0, sold);
        }
    }

    public void addCredit (double val, String reason) throws Exception{
        super.addCredit(val);
        setTransaction(new Transaction(val, false, reason, this.sold));
    }

    @Override
    public void getSold () {
        System.out.println("Le solde de votre Compte courant est de "+this.sold);
    }

    public void displayStatementOfAccount () {
        System.out.println("\n\n\n                       RELEVÉ DE COMPTE");
        System.out.println("Raison --------------------- Valeur --------------------- Solde");
        for(int i =0; i < transactions.size(); i++){
            transactions.get(i).displayTransaction();
        }
        System.out.println("Total ------------------------------------------------- "+sold+"\n\n\n");
    }

    public void setTransaction (Transaction transaction) {
        transactions.add(transaction);
    }

}