/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */
public class main {

    public static void main(String[] args) throws Exception {

        /*******************************************************
        ******************** Compte Courant ********************
        *******************************************************/
        System.out.println("Compte Courant");
        CompteCourant compteCourant = new CompteCourant(0, 5000);
        compteCourant.getSold();
        compteCourant.retreat(1000, "ordinateur");
        compteCourant.addCredit(10000, "héritage");
        try{
            compteCourant.retreat(20000, "erreur");
        }catch(AmountMinimumException e){
            System.out.println(e.getMessage());
        }
        compteCourant.displayStatementOfAccount();
        

        /*******************************************************
        ********************** Compte PEL **********************
        *******************************************************/
        System.out.println("PEL");
        ComptePEL pel = new ComptePEL(2.5, 16000);
        pel.getSold();
        try{            
            pel.retreat(7000);
        }catch(AmountMinimumException e){
            System.out.println(e.getMessage());
        }
        pel.retreat(1000);
        pel.addCredit(2000);
        pel.getSold();
        System.out.println("\n\n\nLDD");

        /*******************************************************
        ********************** Compte LDD **********************
        *******************************************************/
        CompteLDD ldd = new CompteLDD(1.75, 10000);
        ldd.getSold();
        try{            
            ldd.addCredit(3000);
        }
        catch(AmountMaximumException e){
            System.out.println(e.getMessage());
        }
        ldd.addCredit(1500);
       
    }

}