package StreamAPI.Student;

public class Student {
    private String fio;
    private int age;
    private GroupEnum group;

    private String surname;
    private int points;

    public Student(String fio, int age, GroupEnum group) {
        this.fio = fio;
        this.age = age;
        this.group = group;
        surname = fio.split(" ")[0];
    }

    public Student(String fio, int age, GroupEnum group, int points) {
        this.fio = fio;
        this.age = age;
        this.group = group;
        this.points = points;
        surname = fio.split(" ")[0];
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", group=" + group +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GroupEnum getGroup() {
        return group;
    }

    public void setGroup(GroupEnum group) {
        this.group = group;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
