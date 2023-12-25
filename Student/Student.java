package Student;

import java.io.Serializable;

public class Student implements java.lang.Comparable<Student>, Serializable {
    String name, address;
    Integer age, id;
    float gpa;

    public Student(String name, String address, Integer age, Integer id, float gpa) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.id = id;
        this.gpa = gpa;
    }

    public Student() {
    }

    public Student input() {
        System.out.printf("Enter student name: ");
        this.name = System.console().readLine();

        System.out.printf("Enter student id: ");
        this.id = Integer.parseInt(System.console().readLine());

        System.out.printf("Enter student age: ");
        this.age = Integer.parseInt(System.console().readLine());

        System.out.printf("Enter student address: ");
        this.address = System.console().readLine();

        System.out.printf("Enter student GPA: ");
        this.gpa = Float.parseFloat(System.console().readLine());

        return new Student(this.name, this.address, this.age, this.id, this.gpa);
    }

    @Override
    public String toString() {
        return "Name:" + name + "\n" +
                "Id:" + id + "\n" +
                "Age:" + age + "\n" +
                "Gpa:" + gpa + "\n" +
                "Address:" + address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}