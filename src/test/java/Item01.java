import item01.Apple;
import item01.Dog;
import item01.Fruit;
import item01.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("생성자 대신 정적 팩토리 메서드를 고려 하라")
public class Item01 {

    @DisplayName("장점 1. 이름을 가질 수 있다.")
    @Test
    void example_one() {
        Member member = Member.memberWithName("Soon");
        Member member1 = Member.nameAndAge("Soon",31);
//        Member member2 = new Member("soon");
    }

    @DisplayName("장점 2. 호출될 때 마다 인스턴스를 새로 생성하지 않아도 된다.")
    @Test
    void example_two() {
        Dog dog1 = Dog.getInstance();
        Dog dog2 = Dog.getInstance();

        assertSame(dog1,dog2);
    }

    @DisplayName("장점 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다. ")
    @Test
    void example_three() {
        assertEquals(Fruit.createApple().getClass(),Apple.class);
    }



}
