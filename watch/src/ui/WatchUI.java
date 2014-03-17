/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import watch.Mode;
import watch.Watch;
import watch.WatchObserver;

/**
 *
 * @author yousra Chabchoub
 */
public class WatchUI implements ActionListener, WatchObserver {

        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            watch.b();
        }
        else if (e.getSource() == seconds) {
            watch.switchMode(Mode.SECONDS);
        }
        else if (e.getSource() == minutes) {
            watch.switchMode(Mode.MINUTES);
        }
        else if (e.getSource() == hours) {
            watch.switchMode(Mode.HOURS);
        }
    }

    JButton b;
    
    JButton seconds;
    JButton minutes;
    JButton hours;
    
    JLabel display;
    Watch watch;
    
    JPanel layout = new JPanel();

    public WatchUI(JFrame f, Watch watch) {
        this.watch=watch;
        f.setLocation(800, 350);
        f.setTitle("Digital Watch");
        f.setSize(500,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        JLabel title = new JLabel("Digital Watch");
        title.setHorizontalAlignment(JLabel.CENTER);
        display = new JLabel("00:00:00");
        display.setHorizontalAlignment(JLabel.CENTER);
        f.add(title, BorderLayout.NORTH);
        f.add(display, BorderLayout.CENTER);
        b = new JButton("Increment");
        b.addActionListener(this);
        
        
        hours = new JButton("Hours");
        hours.addActionListener(this);
        
        minutes = new JButton("Minutes");
        minutes.addActionListener(this);
        
        seconds = new JButton("Seconds");
        seconds.addActionListener(this);
        
        
        layout.add(hours);
        layout.add(minutes);
        layout.add(seconds);
        layout.add(b);
        
        f.add(layout, BorderLayout.SOUTH);


    }

    public void update(int hour, int minute, int seconds) {
        String shour = hour < 10 ? "0" + hour : "" + hour;
        String sminute = minute < 10 ? "0" + minute : "" + minute;
        String sseconds = seconds < 10 ? "0" + seconds : "" + seconds;
        display.setText(shour + ":" + sminute + ":" + sseconds);
    }

    public void update(int hour, int minute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}