
import item02.NyPizza;
import item02.Pizza;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Item02 {

    @DisplayName("계층형 클래스 빌더 확인")
    @Test
    void example_one() {
        NyPizza pizza = (NyPizza) new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        System.out.println(pizza.toString());
    }
}
