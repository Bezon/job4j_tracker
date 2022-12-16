package ru.job4j.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Иван", 30);
        System.out.println("Имя: " + person.getName() + ", Возраст: " + person.getAge());
        System.out.println(person);
        PersonRecord record = new PersonRecord("Иван", 30, 78);
        System.out.println("Имя: " + record.name() + ", Возраст: " + record.age() + ", Макс Возраст: " + record.maxAge());
        System.out.println(record);
        PersonRecord record1 = new PersonRecord("Иван", 30, 45);
        System.out.println(record.equals(record1));
    }
}
