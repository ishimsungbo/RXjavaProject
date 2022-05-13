package com.im.ssb;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class TodoSample {

    // 발행, 가공, 구독 처리 흐름

    public static void main(String[] args) throws InterruptedException{
        Observable.just(100,200,300,400,500)
                .doOnNext(data-> System.out.println(getThreadName() + " : #doOnNext() : " + data))
                .subscribeOn(Schedulers.io())  // 다른 쓰레드에서 실행하게 된다. 메인쓰레드 종료. 데이터의 가공 흐름 결정
                .observeOn(Schedulers.computation())  //발행과 가공,처리가 다른 쓰레드에서 이루어짐. 가공하고 처리하게 되는 쓰레드 지정
                .filter(number -> number > 300)
                .subscribe(num -> System.out.println(getThreadName() + " : result : " + num));

        Thread.sleep(500);  //RxCachedThreadScheduler-1 다른 쓰레드에서 사용한 동작이 로그로 나옴
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }

}
