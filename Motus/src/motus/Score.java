/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motus;

/**
 *
 * @author Nicolas
 */
public class Score implements Comparable<Score>{
    
    String pseudo;
    int score;
    
    public Score(String p, int s){
        this.pseudo = p;
        this.score = s;
    }
    
    @Override
    public int compareTo(Score s) {
        if(this.score > s.score){
            return 1;
        }
        else if(this.score < s.score){
            return -1;
        }
        return 0;
    }
    
}
