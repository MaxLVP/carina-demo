package com.qaprosoft.carina.demo.db.mysql.mappers;

import com.qaprosoft.carina.demo.db.mysql.models.CarModel;

public interface ICarMapper {

    CarModel findByUserId(long id);
}
