package com.company;

public class CancellationWithFlag {

    public  static volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread one");

        Thread hello = new Thread(() -> {
            while (isRunning) {
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
        isRunning = false;
        System.out.println("Set isRunning to \" status : " + isRunning + "\"");

    }
}
