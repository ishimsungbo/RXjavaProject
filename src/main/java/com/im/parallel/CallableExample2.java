package com.im.parallel;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * ExecutorService
 * ExecutorService도 Callable을 Job으로 등록하고 수행시킬 수 있습니다.
 * 다음 코드처럼 Future를 이용하여 결과를 리턴받을 수 있습니다.
 */
public class CallableExample2 {

    static class UserCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            String result = "MyCallable 1 ";
            Thread.sleep(1000);
            for(int i=0; i<2000 ;i++){
                System.out.println(Thread.currentThread().getName()+" : " + i);
            }
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UserCallable callable = new UserCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);

        //executorService.awaitTermination(Long.MAX_VALUE,TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName() +"  result : " + future.get());

        if(future.isDone()){
            System.out.println("종료함");
            executorService.shutdown();
        }else{
            System.out.println("실행중");
        }
    }

}
