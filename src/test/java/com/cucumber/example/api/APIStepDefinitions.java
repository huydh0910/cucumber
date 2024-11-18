package com.cucumber.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIStepDefinitions {

    private Response response;

    @Given("the API base URI is {string}")
    public void theApiBaseUriIs(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint);
    }

    @When("I send a POST request to {string} with body:")
    public void iSendAPostRequestToWithBody(String endpoint, String body) {
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response body should contain {string} with value {string}")
    public void theResponseBodyShouldContainWithValue(String key, String value) {
        response.then().body(key, equalTo(value));
    }

    @Then("the response body should contain {string}")
    public void theResponseBodyShouldContain(String key) {
        response.then().body(key, notNullValue());
    }
}