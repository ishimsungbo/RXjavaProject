package com.im.parallel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableExample {

    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            String result = "MyCallable 1 ";
            for(int i=0; i<100 ;i++){
                System.out.println("MyCallable 1 : " + i);
            }
            return result;
        }
    }

    /**
     * Runnable: 어떤 객체도 리턴하지 않습니다. Exception을 발생시키지 않습니다.
     * Callable: 특정 타입의 객체를 리턴합니다. Exception을 발생킬 수 있습니다.
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        //리턴 되기를 기다림..
        System.out.println("종료 됨: " + futureTask.get());
    }
}
