package watch;

import javax.swing.JFrame;
import ui.WatchUI;

public class Main {

	public static void main(String[] args) {
            JFrame f=new JFrame();
            Watch w=new Watch();
            WatchUI ui=new WatchUI(f, w);
            w.addWatchObserver(ui);
            //f.pack();
            f.setVisible(true);
	}

}
