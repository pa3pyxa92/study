import java.util.ArrayList;

public class Box implements Shape {

    private ArrayList<Shape> shapeBox = new ArrayList<>();
    private final double volume;
    private double exVolume;

    public Box(double Volume) {
        this.volume = Volume;
        this.exVolume = volume;
    }

    public boolean add(Shape shape){

        if (exVolume - shape.getVolume() <= 0 ){
            return false;
        }

        shapeBox.add(shape);
        exVolume -= shape.getVolume();

        return true;
    }

    public double getExVolume() {
        return this.exVolume;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    @Override
    public String toString() {
        return "Параметры коробки \nОбьем:  " +  this.getVolume() + "\nОставшийся обьем: " + getExVolume();
    }
}