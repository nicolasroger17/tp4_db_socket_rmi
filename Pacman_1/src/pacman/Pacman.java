/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas
 */
public class Pacman extends JFrame{

    public static JFrame window;
    public static JPanel topScore;
    public static JLabel score = new JLabel("score : 0");
    
    
    public static void main(String[] args) {
         window = new JFrame();
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.setTitle("pacman primitif");
         window.setLocation(500, 40);
         window.setSize(720, 820);
         window.setLayout(new BorderLayout());
         createTopScore();
         window.add(topScore, BorderLayout.NORTH);
         
         CheckerBoard checkerboard = new CheckerBoard();
         window.add(checkerboard, BorderLayout.CENTER);
         checkerboard.setFocusable(true);
         
         window.setVisible(true);
    }
    
    public static void createTopScore(){
        topScore = new JPanel();
        topScore.setSize(new Dimension(880, 100));
        //topScore.setBackground(Color.RGBtoHSB(181, 181, 181, new Float{0.3, 0.3, 0.3}));
        topScore.setBackground(Color.LIGHT_GRAY);
        score.setHorizontalTextPosition(JLabel.CENTER);
        topScore.add(score);
    }
    
    public static void updateScore(int value){
        score.setText("score : "+value);
    }
    
    public static void gameOver(){
        score.setText("GAME OVER");
    }
}