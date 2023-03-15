package com.qaprosoft.carina.demo.db.mysql.models;

public class CarBuilder {

    public static CarModel buildCarModel() {
        CarModel carModel = new CarModel();
        carModel.setId(1);
        carModel.setBrand("BMV");
        carModel.setModel("M5");
        return carModel;
    }
}
