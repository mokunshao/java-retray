package com.example.demo.zero;

public class TestProcessesWait {
    private static final Object monitor = new Object();
    private static boolean fileProcessed = false;

    public static class Process1Thread extends Thread {
        public void run() {
            while (!fileProcessed) {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {

                    }
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

            synchronized (monitor) {
                monitor.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        new Process1Thread().start();
        new Process2Thread().start();
    }
}
