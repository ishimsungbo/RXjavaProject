package com.im.rxjavabook2;

import io.reactivex.Observable;

import java.util.function.Function;

public class Rxjava_Map {

    public static String getDiamond1(String ball){
        return ball + "<>";
    }

    public void mapFunction() {
        Function<String, String> getDiamond = ball -> ball + "<>";

    }

    public static void main(String[] args) {

        //Function<String, String> getDiamond = ball -> ball + "<>";

        String[] balls = {"1","2","3","4","5"};

        Observable<String> observer = Observable.fromArray(balls)
                //.map(ball -> ball + "<>");
        .map(ball -> ball + "<>");

        observer.subscribe(System.out::println);


    }
}
