package item34;

public enum Operation2 {
    PLUS("+") {public double apply(double x , double y) {return x+y;}},
    MINUS("-") {public double apply(double x , double y) {return x-y;}};

    private final String symbol;

    Operation2(String symbol) {this.symbol = symbol;}

    @Override public String toString() {return symbol;}

    public abstract double apply(double x, double y);
}
