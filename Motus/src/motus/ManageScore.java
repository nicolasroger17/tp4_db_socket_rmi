/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ManageScore {
    
    public static ArrayList<Score> scores;
    
    public static void sortAndStoreScores(String pseudo, String score) throws IOException{
        scores = new ArrayList();
        scores.add(new Score(pseudo, Integer.parseInt(score)));
        
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        
        try{
            lecteurAvecBuffer = new BufferedReader(new FileReader("scores.txt"));
        }
        catch(FileNotFoundException exc){
            System.out.println("Erreur d'ouverture : "+exc);
        }
        while ((ligne = lecteurAvecBuffer.readLine()) != null){
            String[] oneScore = ligne.split("#");
            scores.add(new Score(oneScore[0], Integer.parseInt(oneScore[1])));
        }
        Collections.sort(scores);
        Collections.reverse(scores);
        
        PrintWriter writer;
        
        writer =  new PrintWriter(new BufferedWriter(new FileWriter("scores.txt")));

        for(int i = 0; i < scores.size() && i < 10; i++){
            writer.println(scores.get(i).pseudo+"#"+scores.get(i).score);
        }
        writer.close();
    }
    
    @Deprecated
    public static void sortArrays(){
        ArrayList<Score> tempScores = new ArrayList();
        int size = scores.size();
        int i = 0;
        int positionMax = 0;
        while(i < size){  
            
            positionMax = 0;
            for(int j = 0; j < scores.size(); j++){
                if(scores.get(j).score>scores.get(positionMax).score){
                    positionMax = j;
                }
            }
            tempScores.add(new Score(scores.get(positionMax).pseudo, scores.get(positionMax).score));
            scores.remove(positionMax);
            i++;
        }
        scores = tempScores;
    }
    
    public static void showScore() throws IOException{
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        
        try{
            lecteurAvecBuffer = new BufferedReader(new FileReader("scores.txt"));
        }
        catch(FileNotFoundException exc){
            System.out.println("Erreur d'ouverture : "+exc);
        }
        System.out.println("\n\nPSEUDO          SCORE\n---------------------------");
        while ((ligne = lecteurAvecBuffer.readLine()) != null){
            String[] oneScore = ligne.split("#");
            System.out.println(oneScore[0]+"        "+oneScore[1]);
        }
        System.out.println("\n");
        lecteurAvecBuffer.close();
    }
}
