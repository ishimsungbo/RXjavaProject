package com.im.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class SecondExample {

    /**
     * just() 함수는 데이터를 인자로 넣으면 자동으로 알림 이벤트가 발행하지만 create() 함수
     * 는 OnNext, onComplete, onError 같은 알림을 개발자가 직접 호출해야 된다. 그래서 create()
     * 는 라이브러리가 무언가를 해준다기보다 개발자가 무언가를 직접 하는 느낌이 강한 함수다.
     *
     *   주의) Observable.create()를 사용할 때는 주의해야 한다.
     *   다른 팩터리 함수를 활용하면 같은 효과를 낼 수 있다.
     */

    public static void emit(){
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                 emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });
        //subscribe를 호출하지 않으면 발행이 안된다.
        //source.subscribe(System.out::println);
        source.subscribe(data ->{System.out.println("Result : " + data);});

        /**
         * 1. 메서드 레퍼런스로 축약할 수 있는지 확인
         * 2. 그다음 람다표현식을 활용할 수 있는지 확인.
         * 3. 1~2를 활용할 수 없으면 익명 객체나 멤버 변수로 표현
         */
    }

    public static void main(String[] args) {
        emit();
    }
}
