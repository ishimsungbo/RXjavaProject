package com.im.rxjavabook2;

import io.reactivex.Observable;

import java.util.function.Function;

public class Rxjava_Map {

    public static String getDiamond1(String ball){
        return ball + "<>";
    }

    public static void main(String[] args) {

        //Function<String, String> getDiamond = ball -> ball + "<>";

        //System.out.println(getDiamond.toString());

    }
}
