package com.javarush.test.level25.lesson05.home01;

/**
 * Created with IntelliJ IDEA.
 * User: vsvld
 * Date: 13.01.2015
 * Time: 12:35
 */
public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = target.getState();
        System.out.println(state);

        while (state != State.TERMINATED) {
            if (state != target.getState()) {
                state = target.getState();
                System.out.println(state);
            }
        }

        this.interrupt();
    }
}
