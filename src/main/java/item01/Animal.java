package item01;

public class Animal {
    private Animal() {}

    public static Cat createCat() {
        return new Cat();
    }
}
