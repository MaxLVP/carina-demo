package com.qaprosoft.carina.demo.db.mysql.models;

import java.util.Objects;

public class PersonModel {
    private long id;
    private String name;
    private String age;
    private CarModel carModel;

    public PersonModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonModel that = (PersonModel) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects.equals(carModel, that.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, carModel);
    }
}
