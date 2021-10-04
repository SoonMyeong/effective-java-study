package item13;

public class Soon {
    private int age;
    private String company;

    Soon(int age, String company) {
        this.age = age;
        this.company = company;
    }

    Soon(Soon soon) {
        this.age = soon.getAge();
        this.company = soon.getCompany();
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Soon{" +
                "age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}
