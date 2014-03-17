package watch;

import java.util.ArrayList;
import java.util.List;

public class Watch {

    public void switchMode(Mode newMode) {
            switch (newMode) {
                case SHOWTIME:
                    mode = Mode.SHOWTIME;
                    break;
                case HOURS:
                    mode = Mode.HOURS;
                    break;
                case MINUTES:
                    mode = Mode.MINUTES;
                    break;
                case SECONDS:
                    mode = Mode.SECONDS;
                    break;
            }
            System.out.println("Mode : "+mode);
    }

    public void b() {
            switch (mode) {
                case HOURS:
                    incrementHours();
                    break;
                case MINUTES:
                    incrementMinutes();
                    break;
                case SECONDS:
                    incrementSeconds();
                    break;
            }
            System.out.println("Manual Increment");
            update();
    }
    
    int hour = 0;
    int minute = 0;
    int seconds = 0;
    Mode mode = Mode.SECONDS;

    public Watch() {
        update();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    switch(mode){
                        case HOURS:
                            incrementHours();
                            break;
                        case MINUTES:
                            incrementMinutes();
                            break;
                        case SECONDS:
                            incrementSeconds();
                            break;
                    }
                    update();
                }
            }
        }).start();
    }

    private void incrementHours() {
        System.out.println("inc hours");
        hour++;
        if (hour > 23) {
            hour = 0;
        }
    }

    private void incrementMinutes() {
        System.out.println("inc minutes");
        minute++;
        if (minute > 59) {
            minute = 0;
            incrementHours();
        }
    }
    
    private void incrementSeconds() {
        System.out.println("inc seconds");
        seconds++;
        if (seconds > 59) {
            seconds = 0;
            incrementMinutes();
        }
    }

    private List<WatchObserver> watchObservers=new ArrayList<WatchObserver>();

    public void addWatchObserver(WatchObserver watchObserver) {
        watchObservers.add(watchObserver);
    }

    private void update() {
        for(WatchObserver o:watchObservers) {
            o.update(hour, minute, seconds);
        }
    }
}