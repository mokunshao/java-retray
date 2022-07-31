package com.example.demo;

public class TestProcessesSleep {
    private static boolean fileProcessed = false;

    public static class Process1Thread extends Thread {
        public void run() {
            while (!fileProcessed) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }

            System.out.println("File Processed, now upload file...");
        }
    }

    public static class Process2Thread extends Thread {
        public void run() {
            System.out.println("Start Processing File...");

            //do some processing on the files here...

            fileProcessed = true;
        }
    }

    public static void main(String[] args) {
        new Process1Thread().start();
        new Process2Thread().start();
    }
}