package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.rest_api_example.DeleteEmployeeMethod;
import com.qaprosoft.carina.demo.api.rest_api_example.GetEmployeeMethod;
import com.qaprosoft.carina.demo.api.rest_api_example.PostEmployeeMethod;
import com.qaprosoft.carina.demo.api.rest_api_example.PutEmployeeMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class RestExampleApiTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetFirstUser() {
        GetEmployeeMethod getEmployeeMethod = new GetEmployeeMethod();
        getEmployeeMethod.callAPIExpectSuccess();
        getEmployeeMethod.validateResponse();
    }

    @Test
    public void testCreateUser() {
        PostEmployeeMethod postEmployeeMethod = new PostEmployeeMethod();
        postEmployeeMethod.setProperties("api/rest_api_example/employee/employee.properties");
        postEmployeeMethod.callAPIExpectSuccess();
        postEmployeeMethod.validateResponse();
    }

    @Test
    public void testChangeFirstUser() {
        PutEmployeeMethod putEmployeeMethod = new PutEmployeeMethod();
        putEmployeeMethod.setProperties("api/rest_api_example/employee/employee.properties");
        putEmployeeMethod.callAPIExpectSuccess();
        putEmployeeMethod.validateResponse();
    }

    @Test
    public void testDeleteUser() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod();
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();

    }
}
