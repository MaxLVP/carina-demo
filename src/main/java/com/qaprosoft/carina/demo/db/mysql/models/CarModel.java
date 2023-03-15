package com.qaprosoft.carina.demo.db.mysql.models;

import java.util.Objects;

public class CarModel {
    private long id;
    private String model;
    private String brand;

    public CarModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return id == carModel.id && Objects.equals(model, carModel.model) && Objects.equals(brand, carModel.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand);
    }
}
