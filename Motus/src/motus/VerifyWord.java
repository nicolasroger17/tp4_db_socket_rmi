package motus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */
public class VerifyWord{
    
    String correctedWord = "";
    boolean allIsOk = true;
    
    public VerifyWord(String word, String realWord){
        int wordSize = realWord.length();
        String[] wordModified = new String[wordSize];
        
        for(int i = 0; i < wordSize; i++){
            wordModified[i] = ".";
        }
        
        for (int i = 0; i < wordSize; i++) {
            if (word.charAt(i) == realWord.charAt(i)) {
                if(i < wordSize){
                    wordModified[i] = word.substring(i, i+1).toUpperCase();
                }
            }
            else{
                allIsOk = false;
                for(int j = 0; j < wordSize; j++){
                    if(word.charAt(i) == realWord.charAt(j)){
                        if(j <= wordSize){
                            wordModified[i] = word.substring(i,i+1);
                        }                        
                    }
                }
            }
        }
        
        for(int i = 0; i < wordModified.length; i++){
            correctedWord += wordModified[i];
        }        
    }
    
}
