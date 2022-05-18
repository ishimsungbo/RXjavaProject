package com.im.rxjavabook1;

import io.reactivex.Observable;

public class Example_fromArray {

    /**
     * 단일 데이터가 아닐때는 fromXXX() 계열 함수를 사용한다.
     * 배열에 들어 있는 데이터를 처리할 때는 fromArray() 함수를 활용하자
     * [참고]사용자 정의 클래스도 넣을 수 있다.
     */

    public static void main(String[] args) {
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
    }
}
