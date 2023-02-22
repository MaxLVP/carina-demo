package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.dummy.GetUserMethod;
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
}
