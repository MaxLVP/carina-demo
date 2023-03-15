package com.qaprosoft.carina.demo.db.mysql.models;

public class PersonBuilder {

    public static PersonModel buildPerson(CarModel carModel) {
        PersonModel personModel = new PersonModel();
        personModel.setId(1);
        personModel.setName("John");
        personModel.setAge("25");
        personModel.setCarModel(carModel);
        return personModel;
    }
}
