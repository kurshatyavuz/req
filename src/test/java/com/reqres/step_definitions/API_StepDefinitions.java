package com.reqres.step_definitions;

import com.reqres.utilities.ConfigurationReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class API_StepDefinitions {

    String listUsersPath = "/api/users";
    String getUser = "/api/users";
    String createUser = "/api/users";

    RequestSpecification reqspec;
    Response response;

    @Given("existing Server application {string}")
    public void existing_Server_application(String string) {
        baseURI = ConfigurationReader.getProperty("baseUri");
        reqspec = given().accept(ContentType.JSON);
    }

    @Then("on GET request to {string} it returns expected users list")
    public void on_GET_request_to_it_returns_expected_users_list(String string) {
        response = reqspec
                .when()
                .get(listUsersPath)
                .prettyPeek();

        JsonPath json = response.jsonPath();
        int actualTotal = json.getInt("total");
        int actualTotal_pages = json.getInt("total_pages");
        int dataSize = json.getList("data").size();
        List<String> expectedFirstNames= Arrays.asList("George", "Janet", "Emma", "Eve", "Charles", "Tracey");
        List<String> expectedLastNames= Arrays.asList("Bluth", "Weaver", "Wong", "Holt", "Morris", "Ramos");
        List<String> actualFirstNames= json.getList("data.first_name");
        List<String> actualLastNames=json.getList("data.last_name");

        Assert.assertEquals(12, actualTotal);
        Assert.assertEquals(2, actualTotal_pages);
        Assert.assertEquals(6, dataSize);
        Assert.assertEquals(expectedFirstNames,actualFirstNames);
        Assert.assertEquals(expectedLastNames,actualLastNames);


    }

    @Then("on GET request to {string} it returns expected welcome message")
    public void on_GET_request_to_it_returns_expected_welcome_message(String string) {

        response = reqspec
                .pathParam("page","2")
                .when()
                .get(listUsersPath + "/{page}")
                .prettyPeek();

        String expectedMessage = "To keep ReqRes free, contributions towards server costs are appreciated!";
        String actualMessage = response.jsonPath().getString("support.text");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Then("on GET request to {string} it returns {int} status code")
    public void on_GET_request_to_it_returns_status_code(String string, Integer int1) {
        response = reqspec
                .pathParam("page","23")
                .when()
                .get(listUsersPath + "/{page}")
                .prettyPeek();

        Assert.assertEquals(404, response.statusCode());
    }


}
