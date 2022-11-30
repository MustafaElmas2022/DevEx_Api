package com.devex.stepDef;

import com.devex.common.DataForApi;
import com.devex.pages.LoginPage;
import com.devex.request.DevexRequest;
import com.devex.utilities.ConfigurationReader;
import com.devex.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class SignUpStepDef {

    Response response;
    String token;
    int id;


    @Given("Users create A POST request with {string} and {string} and {string} and {string} and {string} and {string}")
    public void usersCreateAPOSTRequestWithAndAndAndAndAnd(String email, String password, String name, String google, String facebook, String github) {

      response=  given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(DataForApi.registerUserBody(email, password, name, google, facebook, github))
                .when()
                .post(ConfigurationReader.get("postRegister"));

        System.out.println("response.path(\"token\") = " + response.path("token"));
        System.out.println("response.statusCode() = " + response.statusCode());

    }

    @Then("Verify that body contains {string}")
    public void verifyThatBodyContains(String expectedBody) {
        assertTrue(response.body().asString().contains(expectedBody));
    }

    @Then("Verify status code is {int}")
    public void verifyStatusCodeIs(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());
    }

    @And("Compiler gets the token")
    public void compilerGetsTheToken() {

        token=response.path("token");
        ConfigurationReader.set("newUserToken",token);

    }

    @Given("User create a POST request and send the token with {string} {string} {string} , {string} , {string},{string}, {string} , {string} , {string} , {string} and {string}")
    public void userCreateAPOSTRequestAndSendTheTokenWithAnd(String company, String website, String location, String status, String skills, String githubusername, String youtube, String twitter, String facebook,String linkedin,String instagram) {

      response= DevexRequest.postSaveProfile(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram);

    }

    @Then("User verify that name as {string} and email as {string}")
    public void userVerifyThatNameAsAndEmailAs(String expectedName, String expectedEmail) {

        assertEquals(expectedName,response.path("user.name"));
        assertEquals(expectedEmail,response.path("user.email"));

    }

    @Given("User create a POST request for add an experience with {string},{string},{string},{string},{string},{string},{string}")
    public void userCreateAPOSTRequestForAddAnExperienceWith(String title,String company,String location,String from,String to,String current,String description) {

        response=DevexRequest.postExperience(title, company, location, from, to, current, description);

    }


    @And("Compiler gets the Id")
    public void compilerGetsTheId() {
        id = response.path("experience.id[0]");
        System.out.println("id step = " + id);

    }

    @And("User GET request by id from API")
    public void userGETRequestByIdFromAPI() {

        response=DevexRequest.getExperience(id);


    }

    @And("User is on the Dashboard Page")
    public void userIsOnTheDashboardPage() {
        new LoginPage().setupUI();
    }

    @Then("UI API experience information must be match")
    public void uiAPIExperienceInformationMustBeMatch() {


    }

    @Then("UI API experience information must be match {string}")
    public void uiAPIExperienceInformationMustBeMatch(String company) throws InterruptedException {
        Thread.sleep(2000);
        Driver.get().navigate().refresh();
        //API
      String  expectedCompanyName= response.path("company");

        //UI
        String actualCompanyName= new LoginPage().getNewCompany(company);

        //API vs UI
        assertEquals(expectedCompanyName,actualCompanyName);

        String expectedEngineer= response.path("title");


    }

}
