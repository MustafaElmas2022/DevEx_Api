package com.devex.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Map<String,Object> getAccessToken(String email,String password){

        Map<String,Object> getTokenMap = new HashMap<>();
        getTokenMap.put("email",email);
        getTokenMap.put("password",password);

        Response response = given().log().all()
                .and().contentType(ContentType.JSON)
                .and()
                .body(getTokenMap)
                .when().post("/api/auth");

        String token= response.path("token");
        Map<String,Object> authorization = new HashMap<>();
        authorization.put("x-auth-token",token);

        return authorization;
    }
}
