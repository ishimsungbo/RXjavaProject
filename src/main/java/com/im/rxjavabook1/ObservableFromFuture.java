package com.im.rxjavabook1;

import io.reactivex.Observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ObservableFromFuture {
    public static void main(String[] args) {
        Future<String> future = Executors.newSingleThreadExecutor().submit(()->{
            Thread.sleep(1000);
            return "Hello Future";
        });

        Observable<String> observable = Observable.fromFuture(future);
        observable.subscribe(System.out::println);
    }
}
