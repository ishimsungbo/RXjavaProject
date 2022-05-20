package com.im.toby;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchedulerEx {

    public static void main(String[] args) {

        Publisher<Integer> pub = sub -> {
            sub.onSubscribe(new Subscription() {
                @Override
                public void request(long n) {
                    System.out.println(Thread.currentThread().getName() + " Publisher request start");
                    sub.onNext(1);
                    sub.onNext(2);
                    //System.out.println("Publisher 오잉");
                    sub.onNext(3);
                    sub.onNext(4);
                    sub.onNext(5);
                    sub.onComplete();
                    System.out.println("Publisher request end");
                }

                @Override
                public void cancel() {

                }
            });
        };

        Publisher<Integer> subOnPub = sub -> {
            System.out.println("subOnPub start");
            ExecutorService es = Executors.newSingleThreadExecutor();
            es.execute( ()->pub.subscribe(sub) );
        };

        // sub
        subOnPub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe start");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer i) {
                System.out.println(Thread.currentThread().getName()+" : onNext :" + i);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError : " + t);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

        System.out.println("exit");
    }
}
