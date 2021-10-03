package item13;

public class B extends A {
    private String company;

    B(String name, int age, String company) {
        super(name,age);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public A clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
