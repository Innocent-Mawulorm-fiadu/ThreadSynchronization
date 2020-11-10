package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread one");

        Thread hello = new Thread(() -> {
            while (true) {
                System.out.println("Hello is threading");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        hello.start();
        Thread.sleep(5000);
        hello.interrupt();
        System.out.println("main thread two");

    }
}
