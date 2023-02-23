package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.dummy.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class DummyApiTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetUserById() {
        GetUserMethod getUserMethod = new GetUserMethod("60d0fe4f5311236168a109cb");
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponse();
    }

    @Test
    public void testGetPostById() {
        GetPostMethod getPostMethod = new GetPostMethod("60d21b4967d0d8992e610c90");
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse();
    }

    @Test
    public void testGetCreatedUsers() {
        GetCreatedUsersMethod getCreatedUsersMethod = new GetCreatedUsersMethod();
        getCreatedUsersMethod.addParameter("created", "1");
        getCreatedUsersMethod.callAPIExpectSuccess();
        getCreatedUsersMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey() + "data");
        getCreatedUsersMethod.validateResponseAgainstSchema("api/dummy/users/_get/rs.schema");
    }

    @Test
    public void testCreateUser() {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.setProperties("api/dummy/user.properties");
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
    }

    @Test
    public void testChangeUser() {
        PutUserMethod putUserMethod = new PutUserMethod("63f746c7a9fdf82127982b2f");
        putUserMethod.setProperties("api/dummy/user.properties");
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse();
    }
}
