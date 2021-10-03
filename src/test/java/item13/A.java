package item13;

public class A implements Cloneable{
    private String name;
    private int age;

    A() {}

    A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public A clone() throws CloneNotSupportedException {
        return this;
    }

}
