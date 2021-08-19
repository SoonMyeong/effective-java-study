package item01;

public class Dog {
    //싱글톤+불변객체화
    private static final Dog INSTANCE = new Dog();
    private Dog() {};

    public static Dog getInstance() {return INSTANCE;}
}
