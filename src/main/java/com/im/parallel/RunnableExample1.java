package com.im.parallel;

import java.time.LocalTime;
import java.util.Locale;

/*
Runnable: 어떤 객체도 리턴하지 않습니다. Exception을 발생시키지 않습니다.
Callable: 특정 타입의 객체를 리턴합니다. Exception을 발생킬 수 있습니다.
 */
public class RunnableExample1 {

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            String result = "Called at 1:  " + LocalTime.now();
            for(int i=0; i<100 ;i++){
                System.out.println("쓰레드 1 : " + i);
            }
        }
    }

    static class MyRunnable2 implements Runnable {
        @Override
        public void run() {
            String result = "Called at 2: " + LocalTime.now();
            for(int i=0; i<100 ;i++){
                System.out.println("쓰레드 2 : " + i);
            }

        }
    }

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        MyRunnable2 myRunnable2 = new MyRunnable2();

        //myRunnable2.run();

        Thread thread = new Thread(myRunnable);
        Thread thread2 = new Thread(() -> myRunnable2.run());

        //thread2.start();
        thread.start();

    }

}
