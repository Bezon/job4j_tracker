package ru.job4j.poly;

public interface Transport {
    void drive();

    void setPassengers(int count);

    float refuel(float count);
}
