package motus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PickWord {
    
    public static String pickWord() throws IOException{
        
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        ArrayList<String> listWords = new ArrayList();
        
        try{
            lecteurAvecBuffer = new BufferedReader(new FileReader("dictionnaire.txt"));
        }
        catch(FileNotFoundException exc){
            System.out.println("Erreur d'ouverture : "+exc);
        }
        while ((ligne = lecteurAvecBuffer.readLine()) != null){
            listWords.add(ligne);
        }
        lecteurAvecBuffer.close();
        
        return listWords.get((int) (Math.random()*listWords.size()));
    }
    
}
