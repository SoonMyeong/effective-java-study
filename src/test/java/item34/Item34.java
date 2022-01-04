package item34;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Item34 {

    @DisplayName("데이터와 메서드를 갖는 열거 타입")
    @Test
    void enum_test_1() {
        double earthWeight = 102.1111;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        Arrays.stream(Planet.values()).forEach(planet -> {
            System.out.printf("%s 에서의 무게는 %f 이다.%n", planet,planet.surfaceWeight(mass));
        });
    }

    @DisplayName("상수별 메서드 구현을 활용한 열거 타입 (상수별로 메서드 다르게 동작하게 할 때)")
    @Test
    void enum_test_2() {
        double x = 3.1;
        double y = 5.1;

        System.out.println(Operation1.PLUS.apply(x,y));
    }

    @DisplayName("상수별 클래스 몸체와 데이터를 사용한 열거 타입")
    @Test
    void enum_test_3() {
        double x = 3.1;
        double y = 5.1;

        Arrays.stream(Operation2.values()).forEach(o-> {
            System.out.printf("%f %s %f = %f%n", x,o,y,o.apply(x,y));
        });
    }


    /**
     * 이 열거 타입의 경우 평일일 경우 와 주말일 경우 끼리끼리 같은 동작을 공유 해야 한다.
     * 그냥 test 2처럼 구현할 시 똑같은 구현체를 계속 복붙 해야하는 불상사가...
     */
    @DisplayName("전략 열거 타입 패턴 (열거 타입 상수 일부가 같은 동작을 공유 시 사용하면 편리)")
    @Test
    void enum_test_4() {
        int minutesWorked = 30;
        int payRate = 200000;

        System.out.println("평일에 일할 때 :"+PayrollDay.MONDAY.pay(minutesWorked,payRate));
        System.out.println("주말에 일할 때 :"+PayrollDay.SUNDAY.pay(minutesWorked,payRate));
        System.out.println("--------------------------------------------------");
        System.out.println("[전략패턴 안쓸 경우]평일에 일할 때:"+PayrollDay2.MONDAY.pay(minutesWorked,payRate));
        System.out.println("[전략패턴 안쓸 경우]주말에 일할 때:"+PayrollDay2.SUNDAY.pay(minutesWorked,payRate));
    }

}
