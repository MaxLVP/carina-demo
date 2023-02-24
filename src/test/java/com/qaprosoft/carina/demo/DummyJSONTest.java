package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.DummyJSON.DeleteToDoMethod;
import com.qaprosoft.carina.demo.api.DummyJSON.GetToDoMethod;
import com.qaprosoft.carina.demo.api.DummyJSON.PostToDoMethod;
import com.qaprosoft.carina.demo.api.DummyJSON.PutToDoMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class DummyJSONTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetRandomToDo(){
        GetToDoMethod getToDoMethod = new GetToDoMethod();
        getToDoMethod.callAPIExpectSuccess();
        getToDoMethod.validateResponse();
    }

    @Test
    public void testPostTodo() {
        PostToDoMethod postToDoMethod = new PostToDoMethod();
        postToDoMethod.setProperties("api/dummyJson/todo/todo.properties");
        postToDoMethod.callAPIExpectSuccess();
        postToDoMethod.validateResponse();
    }

    @Test
    public void testDeleteToDo() {
        DeleteToDoMethod deleteToDoMethod = new DeleteToDoMethod();
        deleteToDoMethod.callAPIExpectSuccess();
        deleteToDoMethod.validateResponse();
    }

    @Test
    public void testPutToDo() {
        PutToDoMethod putToDoMethod = new PutToDoMethod();
        putToDoMethod.setProperties("api/dummyJson/todo/todo.properties");
        putToDoMethod.callAPIExpectSuccess();
        putToDoMethod.validateResponse();
    }
}
