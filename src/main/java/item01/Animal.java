package item01;

import item01.Cat;

public class Animal {
    private Animal() {}

    public static Cat createCat() {
        return new Cat();
    }
}
