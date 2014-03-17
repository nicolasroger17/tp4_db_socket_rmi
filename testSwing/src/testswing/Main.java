package testSwing;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("My beautiful window");
        //to stop the process when closing the window 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //to specify how components will be placed 
        f.setLayout(new BorderLayout());
        JButton a = new JButton("A");
        JButton b = new JButton("B");
        JButton c = new JButton("C");
        JButton d = new JButton("D");
        JLabel display = new JLabel("text");
        display.setAlignmentY(50);
        f.add(a, BorderLayout.SOUTH);
        f.add(b, BorderLayout.NORTH);
        f.add(c, BorderLayout.EAST);
        f.add(d, BorderLayout.WEST);
        f.add(display, BorderLayout.CENTER);
        //to fit the size of the window with the components 
        f.pack();
        f.setVisible(true);
    }
}