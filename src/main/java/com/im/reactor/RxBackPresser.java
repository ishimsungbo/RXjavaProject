package com.im.reactor;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class RxBackPresser {

    public static void main(String[] args) {

        PublishSubject<Integer> subject = PublishSubject.create();

        subject.observeOn(Schedulers.computation())
                .subscribe(data -> {
                  // Thread.sleep(100);
                   System.out.println(data);
                }, error -> System.out.println(error.getMessage()));

        for(int i=0; i < 50000000;i++){
            subject.onNext(i);
        }

        subject.onComplete();
    }
}
