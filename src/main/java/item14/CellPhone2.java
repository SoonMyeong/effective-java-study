package item14;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;


public class CellPhone2{

    private int price;
    private String name;

    public CellPhone2(String name, int price) {
        this.name = name;
        this.price = price;
    }

    private static final Comparator<CellPhone2> COMPARATOR =
            comparingInt((CellPhone2 cellPhone) -> cellPhone.price)
                    .thenComparing(cellPhone2 -> cellPhone2.name);


    public int compareTo(CellPhone2 cellPhone2) {
        return COMPARATOR.compare(this,cellPhone2);
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
