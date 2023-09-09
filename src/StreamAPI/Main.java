package StreamAPI;

import StreamAPI.Car.Car;
import StreamAPI.Car.ColorEnum;
import StreamAPI.Car.NameEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;



public class Main {

    private static final int MINSPEED = 10;
    private static final int MAXSPEED = 500;
    public static ColorEnum getRandomColor(){
        ColorEnum[] colors = ColorEnum.values();
        Random random = new Random();
        ColorEnum randomColor = colors[random.nextInt(colors.length)];

        return randomColor;
    }

    public static NameEnum getRandomName(){
        NameEnum[] names = NameEnum.values();
        Random random = new Random();
        NameEnum randomName = names[random.nextInt(names.length)];

        return randomName;
    }

    public static void initList(List<Car> cars){
        for (int i = 0; i < 100; i++) {
            cars.add(new Car(getRandomName(),getRandomColor(),getRandomSpeed()));
        }
    }


    public static int getRandomSpeed(){
        Random random = new Random();

        return random.nextInt(MINSPEED, MAXSPEED);
    }
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        initList(cars);
        Car carWithMaxSpeed = cars.stream()
                .filter(car -> car.getColor() == ColorEnum.RED)
                .max((car1, car2) -> Integer.compare(car1.getMaxSpeed(),car2.getMaxSpeed()))
                .get();
        System.out.println(carWithMaxSpeed);
    }
}