package com.im.rxjavabook1;

import io.reactivex.Observable;

public class FirstExample {

    public static void emit(){
        Observable.just(1,2,3,4,5)
                .subscribe(System.out::println);

    }

    public static void main(String[] args) {
        emit();
    }

}
