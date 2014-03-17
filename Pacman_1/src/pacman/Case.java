/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas
 */
public class Case extends JPanel{
    
    Color color;
    CaseState state = CaseState.EMPTY;
            
    public Case(Color color){
        this.color = color;
        this.setBackground(color);
    }
    
    public void setState(CaseState state){
        switch(state){
            case EMPTY:
                this.state = CaseState.EMPTY;
                this.setBackground(this.color);
            break;
            case PACMAN:
                this.state = CaseState.PACMAN;
                this.setBackground(Color.red);
            break;
            case OBSTACLE:
                this.state = CaseState.OBSTACLE;
                this.setBackground(Color.black);
            break;
            case COIN:
                this.state = CaseState.COIN;
                this.setBackground(Color.YELLOW);
            break;
            case WATER:
                this.state = CaseState.WATER;
                this.setBackground(Color.BLUE);
            break;
            case GRASS:
                this.state = CaseState.GRASS;
                this.setBackground(Color.GREEN);
            break;
            case GHOST:
                this.state = CaseState.GHOST;
                this.setBackground(Color.ORANGE);
            break;
       }
    }
}
