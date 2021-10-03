package item13;

public class D implements Cloneable {
    private Object[] elements;

    D(Object[] elements) {
        this.elements  = elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public void printElements() {
        for(Object i : elements) {
            System.out.print(i.toString());
        }
        System.out.println();
    }

    @Override
    public D clone() throws CloneNotSupportedException {
        D d = (D) super.clone();
        d.elements = elements.clone();
        return d;
    }
}
