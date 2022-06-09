import org.jetbrains.annotations.NotNull;

interface Shape {
    double getVolume();
}

abstract class SolidOfRevolution implements Shape {

    final double radius;

    protected SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    abstract double getRadius();
}

class Cylinder extends SolidOfRevolution implements Shape, Comparable<Cylinder> {

    final private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(getRadius(), 2) * height;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Параметры целиндра \nОбьем:  " + this.getVolume()
                + "\nРадиус: " + this.getRadius()
                + "\nВысота: " + this.height;
    }

    @Override
    public int compareTo(@NotNull Cylinder o) {
        return Double.compare(this.getVolume(), o.getVolume());
    }
}

class Ball extends SolidOfRevolution implements Shape, Comparable<Ball> {

    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(getRadius(), 3) * 4 / 3;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Параметры шара \nОбьем:  " + this.getVolume()
                + "\nРадиус: " + this.getRadius();
    }

    @Override
    public int compareTo(@NotNull Ball o) {
        return Double.compare(this.getVolume(), o.getVolume());
    }
}

class Pyramid implements Shape, Comparable<Pyramid> {
    private final double s;
    private final double h;

    public Pyramid(double s, double h) {
        this.s = s;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return s * h / 3;
    }

    @Override
    public int compareTo(@NotNull Pyramid o) {
        return Double.compare(this.getVolume(), o.getVolume());
    }

    @Override
    public String toString() {
        return "Параметры пирамиды \nОбьем:  " + this.getVolume()
                + "\nПлощадь: " + this.s
                + "\nВысота: " + this.h;
    }

    public class DuplicateEncoder {
        static String encode(String word) {

            char[] wordArr = word.toCharArray();
            for (int i = 0; i < wordArr.length; i++) {
                char temp = wordArr[i];

                for (int j = 0; j < wordArr.length; j++) {
                    if (j != i && word.charAt(j) == temp) {
                        wordArr[i] = ')';
                        wordArr[j] = ')';
                    }
                }

                if (wordArr[i] == temp) {
                    wordArr[i] = '(';
                }
            }

            String result = "";

            for (char ch : wordArr) {
                result += ch;
            }
            return result;
        }
    }
}