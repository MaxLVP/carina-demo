package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.db.mysql.mappers.IPersonMapper;
import com.qaprosoft.carina.demo.db.mysql.models.CarBuilder;
import com.qaprosoft.carina.demo.db.mysql.models.CarModel;
import com.qaprosoft.carina.demo.db.mysql.models.PersonBuilder;
import com.qaprosoft.carina.demo.db.mysql.models.PersonModel;
import com.qaprosoft.carina.demo.utils.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MySqlTest implements IAbstractTest {

    @Test
    public void testPersonInfo() {
        CarModel carModel = CarBuilder.buildCarModel();
        PersonModel personModel = PersonBuilder.buildPerson(carModel);
        PersonModel personModelDB;
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            IPersonMapper personMapper = session.getMapper(IPersonMapper.class);
            personModelDB = personMapper.findPersonById(1);
        }
        Assert.assertEquals(personModel, personModelDB, "Models are not equals");
    }
}
