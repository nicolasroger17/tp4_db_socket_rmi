/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas
 */
public class CheckerBoard extends JPanel{
    
    public int currentPosition = 0;
    public ArrayList<Case> listCase = new ArrayList();
    int score = 0;
    ArrayList<Integer> listPossibleObstacles = new ArrayList();
    
    public CheckerBoard(){
        this.setLayout(new GridLayout(9, 9));
        for(int i = 0; i < 81; i++){
            listCase.add(new Case(i%2==0?Color.GRAY:Color.WHITE));
            this.add(listCase.get(i));
        }
        listCase.get(0).setBackground(Color.red);
        this.addKeyListener(new KeyBoardListener());
        
        //create the list of unique number
        for(int k = 0; k < 81; k++){
            listPossibleObstacles.add(k);
        }
        
        createSpecialCase(CaseState.OBSTACLE);
        createSpecialCase(CaseState.WATER);
        createSpecialCase(CaseState.GRASS);
        createSpecialCase(CaseState.COIN);
        
    }
    
    public final void createSpecialCase(CaseState state){
        for(int j = 0; j < 3; j ++){
            // prevents obstacles in the 3 first cases
            int pos = (int) (Math.random() * (listPossibleObstacles.size() - 3) + 3);
            listCase.get(pos).setState(state);
            listPossibleObstacles.remove(pos);
        }
    }
    
    public class KeyBoardListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                if(checkRightPosAndUpdateScore("up")){
                    listCase.get(currentPosition).setState(CaseState.EMPTY);
                    currentPosition -= 9;
                    listCase.get(currentPosition).setState(CaseState.PACMAN);
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                if(checkRightPosAndUpdateScore("down")){
                    listCase.get(currentPosition).setState(CaseState.EMPTY);
                    currentPosition += 9;
                    listCase.get(currentPosition).setState(CaseState.PACMAN);
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                if(checkRightPosAndUpdateScore("left")){
                    listCase.get(currentPosition).setState(CaseState.EMPTY);
                    currentPosition -= 1;
                    listCase.get(currentPosition).setState(CaseState.PACMAN);
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(checkRightPosAndUpdateScore("right")){
                    listCase.get(currentPosition).setState(CaseState.EMPTY);
                    currentPosition += 1;
                    listCase.get(currentPosition).setState(CaseState.PACMAN);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public boolean checkRightPosAndUpdateScore(String direction){
        boolean isOk = false;
        switch(direction){
            case "up":
                isOk = currentPosition > 8;
                if(isOk){
                    isOk = listCase.get(currentPosition - 9).state != CaseState.OBSTACLE &&
                            listCase.get(currentPosition - 9).state != CaseState.WATER &&
                            listCase.get(currentPosition - 9).state != CaseState.GRASS;
                    if(listCase.get(currentPosition - 9).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }                
            break;
            case "down":
                isOk = currentPosition < 72;
                if(isOk){
                    isOk = listCase.get(currentPosition + 9).state != CaseState.OBSTACLE &&
                            listCase.get(currentPosition + 9).state != CaseState.WATER &&
                            listCase.get(currentPosition + 9).state != CaseState.GRASS;
                    if(listCase.get(currentPosition + 9).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }                
            break;
            case "left":
                isOk = currentPosition % 9 != 0;
                if(isOk){
                    isOk = listCase.get(currentPosition - 1).state != CaseState.OBSTACLE &&
                            listCase.get(currentPosition - 1).state != CaseState.WATER &&
                            listCase.get(currentPosition - 1).state != CaseState.GRASS;
                    if(listCase.get(currentPosition - 1).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }                
            break;
            case "right":
                isOk = currentPosition % 9 != 8;
                if(isOk){
                    isOk = listCase.get(currentPosition + 1).state != CaseState.OBSTACLE &&
                            listCase.get(currentPosition + 1).state != CaseState.WATER &&
                            listCase.get(currentPosition + 1).state != CaseState.GRASS;
                    if(listCase.get(currentPosition + 1).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }                
            break;
        }
        return isOk;
    }
}
