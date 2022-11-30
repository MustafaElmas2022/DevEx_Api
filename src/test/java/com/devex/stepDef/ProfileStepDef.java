package com.devex.stepDef;

import com.devex.request.DevexRequest;
import com.devex.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class ProfileStepDef {

    Response response;

    @Given("Users create a GET request and able to see all profiles")
    public void users_create_a_GET_request_and_able_to_see_all_profiles() {

        response=given().accept(ContentType.JSON)
                .when().get(ConfigurationReader.get("allProfiles"));

        response.prettyPrint();

    }

    @Then("Verify that status code is {int}")
    public void verify_that_status_code_is(int expectedStatusCode) {

        assertEquals(expectedStatusCode,response.statusCode());
    }

    @Given("Users create a GET request and able to see all profiles second way")
    public void usersCreateAGETRequestAndAbleToSeeAllProfilesSecondWay() {
       response=DevexRequest.getAllProfiles();

    }

    @Given("Users create a GET request with path {string}")
    public void usersCreateAGETRequestWithPath(String id) {

        response=DevexRequest.getOneUser(id);

    }

    @Then("Verify that users info {string} and {string} and {string} and {string}")
    public void verifyThatUsersInfoAndAndAnd(String name, String email, String company, String location) {
        assertEquals(name,response.path("user.name"));
        assertEquals(email,response.path("user.email"));
        assertEquals(company,response.path("company"));
        assertEquals(location,response.path("location"));

    }



}
