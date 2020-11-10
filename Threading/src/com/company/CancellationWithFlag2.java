package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class CancellationWithFlag2 {
    public static AtomicBoolean isRunning = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {

        Thread hello = new Thread(() -> {
            while (isRunning.get()) {
                System.out.println("Hello is threading \"status : " + isRunning + "\"");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        hello.start();
        Thread.sleep(5000);
        isRunning.set(false);
        System.out.println("Set isRunning to \" status : " + isRunning + "\"");
    }
}
