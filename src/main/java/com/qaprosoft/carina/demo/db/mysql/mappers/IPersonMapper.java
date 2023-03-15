package com.qaprosoft.carina.demo.db.mysql.mappers;

import com.qaprosoft.carina.demo.db.mysql.models.PersonModel;

public interface IPersonMapper {

    PersonModel findPersonById(long id);
}
