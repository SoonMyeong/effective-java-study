package item13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Item13 {

    @DisplayName("부모클래스의 clone 을 본인 자신의 객체를 리턴하게 끔 변경 시 컴파일 에러는 안나지만 문제가 생김.")
    @Test
    void test01() throws CloneNotSupportedException {
        B b = new B("Soon",31,"neo");
        B b1 = (B) b.clone();
        A a =  b.clone();

        b1.setCompany("SoonWorld"); //case 1) 전혀 독립적으로 동작하고 있지 않음을 테스트 , b만 바꼈는데 b1도 바껴버렸다?? 이럴꺼면 복제 안하지
        //예제에 소개되어 있는 스택에 예제도 elements 필드가 원본을 참조할 뿐이므로 원본이나 복제본을 수정 시 둘 다 값이 변하게 된다.


        assertSame(a,b); //b 클래스를 복제했음에도 내부적으로 super.clone 에 의해 item13.A 클래스와 같게 되버린다.
        Assertions.assertEquals(b.getCompany(),b1.getCompany());
    }

    @DisplayName("상속관계가 아닌 경우 기존 cloneable 을 구현했을 때")
    @Test
    void test02() throws CloneNotSupportedException {
        C c = new C("Soon",31);
        C c1 = c.clone();

        c1.setName("TEST");

        System.out.println("복제본 :" +c1.getName() + ",  원본 : " + c.getName());

        assertNotEquals(c1.getName(),c.getName());
    }

    @DisplayName("가변 상태를 참조하는 클래스용 clone 메서드 작성 시 (재귀적으로 호출)")
    @Test
    void test03() throws CloneNotSupportedException {
        String[] test = {"a","b","c"};
        D d = new D(test);

        D d1 = d.clone();

        String[] elements  = {"c","b","a"};
        d1.setElements(elements);
        d.printElements();
        d1.printElements();
    }

    @DisplayName("해시테이블에서 clone 을 재귀적으로 호출 시 발생하는 문제 확인")
    @Test
    void test04() throws CloneNotSupportedException {
         HashTable hashTable = new HashTable();
         hashTable.put("one","testOne");
         hashTable.put("two","testTwo");
         hashTable.put("three","testThree");

         HashTable cloneHash = hashTable.clone();
         cloneHash.put("four","testFour");

         hashTable.print();
         cloneHash.print();
    }

    @DisplayName("test04 의 문제를 해결 해보자")
    @Test
    void test05() throws CloneNotSupportedException {
        HashTable2 hashTable = new HashTable2();
        hashTable.put("one","testOne");
        hashTable.put("two","testTwo");
        hashTable.put("three","testThree");

        HashTable2 cloneHash = hashTable.clone();
        cloneHash.put("four","testFour");

        hashTable.print();
        cloneHash.print();
    }

    @DisplayName("복사 생성자 소개")
    @Test
    void test06() {
        Soon soon = new Soon(31,"SoonWorld");
        Soon soon1 = new Soon(soon);
        soon1.setAge(20);
        System.out.println(soon.toString());
        System.out.println(soon1.toString());
    }

}
