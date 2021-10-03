package item13;

public class C implements Cloneable{
    private String name;
    private int age;

    C() {}

    C(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public C clone() throws CloneNotSupportedException {
        return (C) super.clone();
    }

}
