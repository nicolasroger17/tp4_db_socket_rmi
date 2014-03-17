/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motus;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class Motus {
    
    public static String word;
    public static String givenWord;
    public static int nbOfTurn = 0;
    public static String score = "";
    
    public static void main(String[] args) {
        boolean replay = true;
        welcomeAndRules();
        while(replay){
            newGame();
            try {
                ManageScore.showScore();
            } catch (IOException ex) {
                System.out.println("can't access scores.txt");
            }
            replay = wantsToReplay();
        }
    }
    
    public static void welcomeAndRules(){
        System.out.println("                      BIENVENUE DANS LE JEU MOTUS\n");
        System.out.println("Règles du jeu :\nUn « mot secret »" +
        "sera choisi au hasard parmi plusieurs mots. La première lettre du mot secret vous sera donnée.\n" +
        "Vous aurez alors 7 tentatives pour deviner le mot. Pour chaque proposition, les lettres\n" +
        "qui sont bien placées seront affichées an majuscule, celles qui font partie du mot, mais sont\n" +
        "mal placées seront affichées en minuscule et celles qui n’appartiennent pas au mot secret\n" +
        "seront remplacées par « . » .");
    }
    
    public static String askForWord(){
        String str = "";
        boolean goodLength = false;
        while(!goodLength){
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
            goodLength = str.length()==word.length()?true:false;
            if(!goodLength){
                System.out.println("Le mot que vous avez entré n'a pas le bon nombre de lettres");
            }
        }
        return str.substring(0, str.length()).toLowerCase();
    }
    
    public static String askPseudo(){
        System.out.println("Entrez votre pseudo");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }
    
    public static void newGame(){
        try{
            word = PickWord.pickWord();
        }
        catch(Exception e){
            System.out.println("Impossible de récupérer le dictionnaire");
            System.exit(1);
        }
        //System.out.println("Word picked : "+word);
        for(int i = 0; i < word.length(); i++){
            if(i == 0){
                System.out.print(word.charAt(0));
            }
            else{
                System.out.print(".");
            }
        }
        System.out.println();
        for(nbOfTurn = 0; nbOfTurn < word.length(); nbOfTurn++){
            givenWord = askForWord();
            VerifyWord verifyWord = new VerifyWord(givenWord, word);
            System.out.println(verifyWord.correctedWord);
            if(verifyWord.allIsOk){
                break;
            }
        }
        score = ""+(word.length()-nbOfTurn);
        System.out.println("Votre score est de : "+score);
        try {
            ManageScore.sortAndStoreScores(askPseudo(), score);
        } catch (IOException ex) {
            System.out.println("Can't Open scores.txt");
        }
    }
    
    public static boolean wantsToReplay(){
        System.out.println("Si vous souhaitez continuer, entrez o,\nsinon appuyez sur entrer pour quitter");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean wantsToReplay = str.equals("o");
        if(wantsToReplay){
            System.out.println("\n\n\n\nGénial, en avant pour une nouvelle partie de folie !!!");
        }
        return wantsToReplay;
    }
}
