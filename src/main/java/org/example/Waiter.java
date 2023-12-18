package org.example;

//import java.util.concurrent.TimeUnit;

public class Waiter {
    public static void waitSeconds(int seconds) {
        try {
            //TimeUnit.SECONDS.sleep(seconds);
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitMilliSeconds(int milliSeconds) {
        try {
            //TmeUnit.MICROSECONDS.sleep(milliSeconds);
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
