package com.pengxg.demo.thread;

/**
 * 两个线程交替打印问题
 */
public class PrintOneByOne {
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    synchronized (object){
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("A");
                        object.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    synchronized (object){
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("a");
                        object.notify();
                    }
                }

            }
        }).start();
    }

}
