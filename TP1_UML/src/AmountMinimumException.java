public class AmountMinimumException extends Exception {

    public AmountMinimumException (double amount, double cap, double sold) {
        super("Vous ne pouvez pas retirer autant d'argent de votre compte, vous souhaitez retirer : "+amount+
        " à votre compte qui contient "+sold+
        " et le minimum requis sur le compte est de "+cap);
    }

}