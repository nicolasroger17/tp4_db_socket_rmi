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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas
 */
public class CheckerBoard extends JPanel{
    
    public int currentPosition = 10;
    public int ghostPos = 43;
    public ArrayList<Case> listCase = new ArrayList();
    int score = 0;
    ArrayList<Integer> listPossibleObstacles = new ArrayList();
    Timer timer;
    boolean gameIsOver = false;
    
    public CheckerBoard(){
        this.setLayout(new GridLayout(9, 9));
        for(int i = 0; i < 81; i++){
            listCase.add(new Case(i%2==0?Color.GRAY:Color.WHITE));
            this.add(listCase.get(i));
        }
        listCase.get(currentPosition).setState(CaseState.PACMAN);
        listCase.get(ghostPos).setState(CaseState.GHOST);
        this.addKeyListener(new KeyBoardListener());
        
        //create the list of unique number
        for(int k = 0; k < 81; k++){
            listPossibleObstacles.add(k);
        }
        /*createSpecialCase(CaseState.OBSTACLE);
        createSpecialCase(CaseState.WATER);
        createSpecialCase(CaseState.GRASS);
        createSpecialCase(CaseState.COIN);*/
        createBorderCase();
        startGhost();
    }
    
    public final void createSpecialCase(CaseState state){
        for(int j = 0; j < 3; j ++){
            // prevents obstacles in the 3 first cases
            int pos = (int) (Math.random() * (listPossibleObstacles.size() - 3) + 3);
            listCase.get(pos).setState(state);
            listPossibleObstacles.remove(pos);
        }
    }
    
    public final void createBorderCase(){
        for(int j = 0; j < 9; j ++){
            listCase.get(j).setState(CaseState.OBSTACLE);
            listCase.get(72+j).setState(CaseState.OBSTACLE);
        }
        for(int j = 0; j < 9; j ++){
            listCase.get(j*9).setState(CaseState.OBSTACLE);
            listCase.get(j*9+8).setState(CaseState.OBSTACLE);
        }
        listCase.get(20).setState(CaseState.OBSTACLE);
        listCase.get(21).setState(CaseState.OBSTACLE);
        listCase.get(29).setState(CaseState.OBSTACLE);
        
        listCase.get(23).setState(CaseState.OBSTACLE);
        listCase.get(24).setState(CaseState.OBSTACLE);
        listCase.get(33).setState(CaseState.OBSTACLE);
        
        listCase.get(47).setState(CaseState.OBSTACLE);
        listCase.get(56).setState(CaseState.OBSTACLE);
        listCase.get(57).setState(CaseState.OBSTACLE);
        
        listCase.get(59).setState(CaseState.OBSTACLE);
        listCase.get(60).setState(CaseState.OBSTACLE);
        listCase.get(51).setState(CaseState.OBSTACLE);
        moveGhost();
    }
    
    public class KeyBoardListener implements KeyListener{
        
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if(!gameIsOver){
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    if(checkRightPosAndUpdateScore("up", currentPosition)){
                        listCase.get(currentPosition).setState(CaseState.EMPTY);
                        currentPosition -= 9;
                        listCase.get(currentPosition).setState(CaseState.PACMAN);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if(checkRightPosAndUpdateScore("down", currentPosition)){
                        listCase.get(currentPosition).setState(CaseState.EMPTY);
                        currentPosition += 9;
                        listCase.get(currentPosition).setState(CaseState.PACMAN);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if(checkRightPosAndUpdateScore("left", currentPosition)){
                        listCase.get(currentPosition).setState(CaseState.EMPTY);
                        currentPosition -= 1;
                        listCase.get(currentPosition).setState(CaseState.PACMAN);
                    }
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(checkRightPosAndUpdateScore("right", currentPosition)){
                        listCase.get(currentPosition).setState(CaseState.EMPTY);
                        currentPosition += 1;
                        listCase.get(currentPosition).setState(CaseState.PACMAN);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public void startGhost(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                moveGhost();
            }
            
        }, 0, 500);
    }
    
    public void moveGhost(){
        switch((int) (Math.random() * (3))){
                case 0:
                    if(checkRightPosAndUpdateScore("up",ghostPos)){
                        listCase.get(ghostPos).setState(CaseState.EMPTY);
                        ghostPos -= 9;
                        listCase.get(ghostPos).setState(CaseState.GHOST);
                    }
                    break;
                case 1:
                    if(checkRightPosAndUpdateScore("down",ghostPos)){
                        listCase.get(ghostPos).setState(CaseState.EMPTY);
                        ghostPos += 9;
                        listCase.get(ghostPos).setState(CaseState.GHOST);
                    } 
                    break;
                case 2:
                    if(checkRightPosAndUpdateScore("left",ghostPos)){
                        listCase.get(ghostPos).setState(CaseState.EMPTY);
                        ghostPos -= 1;
                        listCase.get(ghostPos).setState(CaseState.GHOST);
                    } 
                    break;
                case 3:
                    if(checkRightPosAndUpdateScore("right",ghostPos)){
                        listCase.get(ghostPos).setState(CaseState.EMPTY);
                        ghostPos += 1;
                        listCase.get(ghostPos).setState(CaseState.GHOST);
                    } 
                    break;
            }
    }
    
    public boolean checkRightPosAndUpdateScore(String direction, int element){
        boolean isOk = false;
        switch(direction){
            case "up":
                isOk = element > 8;
                if(isOk){
                    isOk = listCase.get(element - 9).state != CaseState.OBSTACLE &&
                            listCase.get(element - 9).state != CaseState.WATER &&
                            listCase.get(element - 9).state != CaseState.GRASS;
                    if(listCase.get(element - 9).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }
            break;
            case "down":
                isOk = element < 72;
                if(isOk){
                    isOk = listCase.get(element + 9).state != CaseState.OBSTACLE &&
                            listCase.get(element + 9).state != CaseState.WATER &&
                            listCase.get(element + 9).state != CaseState.GRASS;
                    if(listCase.get(element + 9).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }
            break;
            case "left":
                isOk = element % 9 != 0;
                if(isOk){
                    isOk = listCase.get(element - 1).state != CaseState.OBSTACLE &&
                            listCase.get(element - 1).state != CaseState.WATER &&
                            listCase.get(element - 1).state != CaseState.GRASS;
                    if(listCase.get(element - 1).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }
            break;
            case "right":
                isOk = element % 9 != 8;
                if(isOk){
                    isOk = listCase.get(element + 1).state != CaseState.OBSTACLE &&
                            listCase.get(element + 1).state != CaseState.WATER &&
                            listCase.get(element + 1).state != CaseState.GRASS;
                    if(listCase.get(element + 1).state == CaseState.COIN){
                        score++;
                        Pacman.updateScore(score);
                    }
                }
            break;
        }
        if(listCase.get(currentPosition).state.equals(listCase.get(ghostPos).state)){
            timer.cancel();
            Pacman.gameOver();
            gameIsOver = true;
            listCase.get(currentPosition).setState(CaseState.GHOST);
        }
        return isOk;
    }
}