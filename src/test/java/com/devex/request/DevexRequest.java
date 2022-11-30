package com.devex.request;

import com.devex.common.DataForApi;
import com.devex.utilities.ApiUtils;
import com.devex.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DevexRequest {

   static Response response;

    public static Response getAllProfiles(){
        response = given().accept(ContentType.JSON)
                .when().log().all()
                .get(ConfigurationReader.get("allProfiles"));
        response.prettyPrint();
        return response;

    }
    public static Response getOneUser(String id){
       response= given().accept(ContentType.JSON).and()
                .pathParam("userID",id)
                .when().get(ConfigurationReader.get("getOneUser"));

       return response;
    }

    public static Response postSaveProfile(String company, String website, String location, String status, String skills, String githubusername, String youtube, String twitter, String facebook,String linkedin,String instagram){

        response= given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .header("x-auth-token",ConfigurationReader.get("newUserToken"))
                .and()
                .body(DataForApi.saveProfileBody(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram))
                .when()
                .post(ConfigurationReader.get("allProfiles"));

        response.prettyPrint();

        return response;
    }

    public static Response postExperience(String title,String company,String location,String from,String to,String current,String description){
        response=given().log().all()
                .and()
                .contentType(ContentType.JSON)
                .and()
                .headers(ApiUtils.getAccessToken(ConfigurationReader.get("email"),ConfigurationReader.get("password")))
                .and()
                .body(DataForApi.addExperienceBody(title, company, location, from, to, current, description))
                .when()
                .post(ConfigurationReader.get("postExperience"));
        response.prettyPrint();
        return response;

    }

    public static Response getExperience(int id){

        response = given().log().all()
                .and()
                .contentType(ContentType.JSON)
                .and()
                .headers(ApiUtils.getAccessToken(ConfigurationReader.get("email"),ConfigurationReader.get("password")))
                .and()
                .pathParam("id",id)
                .and()
                .get(ConfigurationReader.get("getExperienceById"));

        response.prettyPrint();
        return response;
    }

}
