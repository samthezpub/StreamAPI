package StreamAPI;

import StreamAPI.Car.Car;
import StreamAPI.Car.ColorEnum;
import StreamAPI.Car.NameEnum;
import StreamAPI.Employee.Employee;
import StreamAPI.Student.GroupEnum;
import StreamAPI.Student.PatronymicEnum;
import StreamAPI.Student.Student;
import StreamAPI.Student.SurnameEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;


public class Main {

    private static final int MINSPEED = 10;
    private static final int MAXSPEED = 500;

    public static ColorEnum getRandomColor() {
        ColorEnum[] colors = ColorEnum.values();
        Random random = new Random();
        ColorEnum randomColor = colors[random.nextInt(colors.length)];

        return randomColor;
    }

    public static NameEnum getRandomName() {
        NameEnum[] names = NameEnum.values();
        Random random = new Random();
        NameEnum randomName = names[random.nextInt(names.length)];

        return randomName;
    }

    public static void initList(List<Car> cars) {
        for (int i = 0; i < 100; i++) {
            cars.add(new Car(getRandomName(), getRandomColor(), getRandomSpeed()));
        }
    }

    public static void initStudentList(List<Student> students) {
        for (int i = 0; i < 100; i++) {
            students.add(new Student(getRandomFio(), getRandomAge(), getRandomGroup()));
        }
    }

    public static void initStudentList(List<Student> students, boolean points) {
        if (points) {
            for (int i = 0; i < 100; i++) {
                students.add(new Student(getRandomFio(), getRandomAge(), getRandomGroup(), getRandomPoints()));
            }
        } else initStudentList(students);

    }


    public static int getRandomSpeed() {
        Random random = new Random();

        return random.nextInt(MINSPEED, MAXSPEED);
    }

    public static int getRandomAge() {
        Random random = new Random();
        return random.nextInt(10, 140);
    }

    public static String getRandomFio() {
        Random random = new Random();
        String randomName = StreamAPI.Student.NameEnum.values()[random.nextInt(NameEnum.values().length)].toString();
        String randomSurname = StreamAPI.Student.SurnameEnum.values()[random.nextInt(SurnameEnum.values().length)].toString();
        String randomPatronymic = StreamAPI.Student.PatronymicEnum.values()[random.nextInt(PatronymicEnum.values().length)].toString();
        return randomSurname + " " + randomName + " " + randomPatronymic;
    }

    public static GroupEnum getRandomGroup() {
        Random random = new Random();
        return StreamAPI.Student.GroupEnum.values()[random.nextInt(GroupEnum.values().length)];
    }

    public static int getRandomPoints() {
        Random random = new Random();
        return random.nextInt(3, 300);
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        initList(cars);
        Car carWithMaxSpeed = cars.stream()
                .filter(car -> car.getColor() == ColorEnum.RED)
                .max((car1, car2) -> Integer.compare(car1.getMaxSpeed(), car2.getMaxSpeed()))
                .get();
        System.out.println(carWithMaxSpeed);

        List<Student> students = new ArrayList<>();
        initStudentList(students);
        students.stream().filter(student -> student.getAge() < 15).forEach(student -> System.out.println(student.getSurname()));


        List<Student> students1 = new ArrayList<>();
        initStudentList(students1, true);

        double points = Math.round(students1.stream().mapToInt(Student::getPoints)
                .average()
                .getAsDouble());

        System.out.println(points);


        List<Employee> employees = new ArrayList<>();
        employees =  students1.stream()
                .map(student -> new Employee(student.getFio().split(" ")[1], student.getSurname(), student.getFio().split(" ")[2], student.getAge()))
                .collect(Collectors.toList());

        System.out.println(employees);
    }
}