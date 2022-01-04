package item34;

public enum Planet {
    EARTH(5.975e+24, 6.378e6);

    private final double mass; //질량
    private final double radius; //반지름
    private final double surfaceGravity; //표면중력

    private static final double G = 6.67300E-11; //중력 상수..

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {return mass;}
    public double radius() {return radius;}
    public double surfaceGravity() {return surfaceGravity;}

    public double surfaceWeight(double mass){
        return mass * surfaceGravity;
    }
}
