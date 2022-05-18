package com.im.rxtest;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BasicCh01 {
    public static void main(String[] args) {

        System.out.println("쓰레드 명 : " + Thread.currentThread().getName());

        Observable<String> databases = Observable.just("1","2","3","4","5");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("onSubscribe : " + disposable.isDisposed());
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext : " + s);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        databases //subscribeOn(Schedulers.newThread())
                //.doOnNext(s-> System.out.println("doOnNext : " + s))
                //.doOnSubscribe(s-> System.out.println("2 : doOnSubscribe : " + s.isDisposed()))
                .subscribe(observer);



    }
}
