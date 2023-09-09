package StreamAPI.Car;

import java.util.Objects;

public class Car {
    private final NameEnum name;
    private final ColorEnum color;
    private final int maxSpeed;

    public Car(NameEnum name, ColorEnum color, int maxSpeed) {
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", color=" + color +
                ", maxSpeed=" + maxSpeed +
                '}';
    }


    public NameEnum getName() {
        return name;
    }

    public ColorEnum getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
