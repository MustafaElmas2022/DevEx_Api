package com.devex.stepDef;

import com.devex.utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {


    @Before
    public void setup() {
        baseURI=ConfigurationReader.get("baseURI");
    }

    @After
    public void tearDown(){
        reset();
    }
}
