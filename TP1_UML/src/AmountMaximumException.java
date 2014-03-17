
public class AmountMaximumException extends Exception {

    public AmountMaximumException (double amount, double cap, double sold) {
        super("Vous ne pouvez pas ajouter autant d'argent à votre compte, vous souhaitez ajouter : "+amount+
        " à votre compte qui contient "+sold+
        " et le maximum est de "+cap);
    }

}