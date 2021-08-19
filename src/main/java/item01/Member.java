package item01;

public class Member {
    private String name;
    private int age;

    //생성자를 private 으로 막아 불필요한 객체 생성을 피할 수 있게 함
    private Member(String name) {
        this.name = name;
    }
    private Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Member memberWithName(String name) {
        return new Member(name);
    }

    public static Member nameAndAge(String name, int age) {
        return new Member(name,age);
    }

}
