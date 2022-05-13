package com.im.ssb;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MarbleExample01 {
    public static void main(String[] args) {
        Observable.just(1,25,9,15,7,30)  //발행
                .filter(x-> x > 10)       //가공
                .subscribe( s-> new Test().sendMail(s)); //구독
    }

    static class Test {
        public void sendMail(int i) {
            System.out.println("메일을 보냅니다." + i);
        }
    }
}
