package com.im.reactor;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DefaultObserver;

public class RXjava01 {

    public static String Hello(){
        return "Hello";
    }
    public static String RxJava(){
        return "RxJava";
    }

    public static void main(String[] args) {
        Observable.just(Hello()," ", RxJava())
                .doOnNext(s-> System.out.println("doOnNext : " + s))
                .subscribe(new DefaultObserver<String>() {
                    @Override
                    public void onNext(@NonNull String s) {
                        System.out.println("onNext : " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        System.out.println("Error  : " + throwable.toString());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete()");
                    }
                });

    }
}
