import item14.CellPhone;
import item14.CellPhone2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Item14 {

    @DisplayName("Comparable 인터페이스의 메서드 compareTo 구현 예시")
    @Test
    void test01() {
        //compareTo 메서드를 호출하는 객체가 주어진 객체보다 비교 후 작으면 음의 정수,
        // 같으면 0,
        // 크면 양의 정수 반환

        CellPhone iphone = new CellPhone("아이폰13",90);
        CellPhone gelaxyZFlip = new CellPhone("갤럭시Z플립",100);

        int result = iphone.compareTo(gelaxyZFlip);
        if(result <0) {
            System.out.println("아이폰보다 가격이 비싸거나 자음 순서가 더 뒤에 있는 순서 이다.");
        }else if(result ==0) {
            System.out.println("아이폰과 비교하는 휴대폰은 이름과 가격 모두 같다. ");
        }else {
            System.out.println("아이폰이 비교 대상보다 가격이 비싸거나 자음 순서가 더 뒤에 있는 순서 이다.");
        }

        List<CellPhone> list = new ArrayList<>();

        list.add(gelaxyZFlip);
        list.add(iphone);

        list.forEach(System.out::println);
        System.out.println("============================");

        Collections.sort(list); //우리가 아까 주로 사용된다던 Collections or Arrays ! 기억하고 있는가!
                                // -> list 의 경우 내부적으로 Arrays.sort 가 실행된다.
        list.forEach(System.out::println);
    }
    
    @DisplayName("비교자 생성 메서드를 활용")
    @Test
    void test02() {
        CellPhone2 iphone = new CellPhone2("아이폰13",120);
        CellPhone2 gelaxyZFlip = new CellPhone2("갤럭시Z플립",120);

        int result = iphone.compareTo(gelaxyZFlip);
        if(result <0) {
            System.out.println("아이폰보다 가격이 비싸거나 자음 순서가 더 뒤에 있는 순서 이다.");
        }else if(result ==0) {
            System.out.println("아이폰과 비교하는 휴대폰은 이름과 가격 모두 같다. ");
        }else {
            System.out.println("아이폰이 비교 대상보다 가격이 비싸거나 자음 순서가 더 뒤에 있는 순서 이다.");
        }
    }

    @DisplayName("람다를 활용한 Comparator 인터페이스의 compare 메서드")
    @Test
    void test3() {
        CellPhone2 iphone = new CellPhone2("아이폰13",90);
        CellPhone2 gelaxyZFlip = new CellPhone2("갤럭시Z플립",100);

        List<CellPhone2> list = new ArrayList<>();

        list.add(gelaxyZFlip);
        list.add(iphone);

// 람다식 보여주기 전 풀어 쓴 모습
//        list.sort(new Comparator<CellPhone2>() {
//            @Override
//            public int compare(CellPhone2 o1, CellPhone2 o2) {
//              int result = Integer.compare(o1.getPrice(),o2.getPrice());
    //            if(result==0) {
    //                return o1.compareTo(o2);
    //            }
//               return result;
//            }
//        });

        list.forEach(System.out::println);
        System.out.println("============================");
        
        //람다 표현
        list.sort((o1, o2) -> {
            int result = Integer.compare(o1.getPrice(),o2.getPrice());
            if(result==0) {
                return o1.compareTo(o2);
            }
            return result;
        });

        list.forEach(System.out::println);

    }




}
