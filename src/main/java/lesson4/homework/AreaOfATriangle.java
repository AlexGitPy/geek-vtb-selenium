package lesson4.homework;

public class AreaOfATriangle {

    public double areaOfATriangle(double a, double b, double c) {
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
