package item14;

public class CellPhone implements Comparable<CellPhone>{

    private int price;
    private String name;

    public CellPhone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(CellPhone c) {
       int result = Integer.compare(price,c.price); // 박싱된 기본 타입 클래스들에 추가된 정적 메서드
       if(result==0) {
           result = name.compareTo(c.name);
       }
       return result;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
