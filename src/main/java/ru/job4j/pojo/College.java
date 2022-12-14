package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDate("20.12.2022");
        student.setName("Ivanov Ivan Ivanovich");
        student.setGroup("A");
        System.out.println(student.getName() + " " + student.getGroup() + " " + student.getDate());
    }
}
