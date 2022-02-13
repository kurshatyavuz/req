package com.reqres.step_definitions;

import com.reqres.model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API_StepDefinitions2 {

    RequestSpecification reqspec;
    Response response;


    @Given("existing server application is {string}")
    public void existing_server_application_is(String baseUri) {
        baseURI = baseUri;
        reqspec = given()
                .log().all()
                .contentType(ContentType.JSON);
    }



    @Then("POST new registration {string} and {string} to register endpoint returns expected {string} and {string} and {string} using request body in String")
    public void post_new_registration_using_request_body_in_string(String email, String password, String statusCode,String id, String token) {

        String requestBody = "{\n" +
                "    \"email\": \"" + email+ "\",\n" +
                "    \"password\": \""+ password + "\"\n" +
                "}";

//        Method 1
        response = reqspec
                .body(requestBody)
                .when()
                .post("/register")
                .prettyPeek();

        System.out.println("Returned response : " + response.asString());
        System.out.println("Returned id       : " + response.jsonPath().getInt("id"));
        System.out.println("Returned token    : " + response.jsonPath().get("token"));
        System.out.println("Returned token    : " + response.jsonPath().getString("token"));

        Assert.assertEquals(statusCode,String.valueOf(response.statusCode()));
        Assert.assertEquals(id, String.valueOf(response.jsonPath().getInt("id")));
        Assert.assertEquals(token, response.jsonPath().get("token"));


//         Method 2
        reqspec
                .body(requestBody)
                .when()
                .post("/register")
                .then()
                .log().ifValidationFails()
                .statusCode(Integer.parseInt(statusCode))
                .body("id",is(Integer.parseInt(id)))
                .body("token",is(token))
                .body("token",equalTo(token));

    }





    @Then("POST new registration {string} and {string} to register endpoint returns expected {string} and {string} and {string} using request body in POJO")
    public void post_new_registration_using_request_body_in_POJO(String email, String password, String statusCode,String id, String token) {
        User user = new User(email,password);
//        Method 1
        response = reqspec
                .body(user)
                .when()
                .post("/register")
                .prettyPeek();

        System.out.println("Returned response : " + response.asString());
        System.out.println("Returned id       : " + response.jsonPath().getInt("id"));
        System.out.println("Returned token    : " + response.jsonPath().get("token"));
        System.out.println("Returned token    : " + response.jsonPath().getString("token"));

        Assert.assertEquals(statusCode,String.valueOf(response.statusCode()));
        Assert.assertEquals(id, String.valueOf(response.jsonPath().getInt("id")));
        Assert.assertEquals(token, response.jsonPath().get("token"));
    }




    @Then("POST new registration {string} and {string} to register endpoint returns expected {string} and {string} and {string} using request body in Map")
    public void post_new_registration_using_request_body_in_Map(String email, String password, String statusCode,String id, String token) {

        Map<String,String> map = new HashMap();
        map.put("email",email);
        map.put("password",password);


//        Method 1
        response = reqspec
                .body(map)
                .when()
                .post("/register")
                .prettyPeek();

        System.out.println("Returned response    : " + response.asString());
        System.out.println("Returned status code : " + response.statusCode());
        System.out.println("Returned id          : " + response.jsonPath().getInt("id"));
        System.out.println("Returned token       : " + response.jsonPath().get("token"));
        System.out.println("Returned token       : " + response.jsonPath().getString("token"));

        Assert.assertEquals(statusCode,String.valueOf(response.statusCode()));
        Assert.assertEquals(id, String.valueOf(response.jsonPath().getInt("id")));
        Assert.assertEquals(token, response.jsonPath().get("token"));
    }





    @Then("POST new registration {string} and {string} to register endpoint returns expected {string} and {string} and {string} using request body in Json String")
    public void post_new_registration_using_request_body_in_json_string(String email, String password, String statusCode,String id, String token) {

        JsonObject json = new JsonObject();
        json.addProperty("email",email);
        json.addProperty("password",password);

        String requestBody = json.getAsJsonObject().toString();

//        Method 1
        response = reqspec
                .body(requestBody)
                .when()
                .post("/register")
                .prettyPeek();

        System.out.println("Request body      : " + requestBody);
        System.out.println("Returned response : " + response.asString());
        System.out.println("Returned status code : " + response.statusCode());
        System.out.println("Returned id       : " + response.jsonPath().getInt("id"));
        System.out.println("Returned token    : " + response.jsonPath().get("token"));
        System.out.println("Returned token    : " + response.jsonPath().getString("token"));

        Assert.assertEquals(statusCode,String.valueOf(response.statusCode()));
        Assert.assertEquals(id, String.valueOf(response.jsonPath().getInt("id")));
        Assert.assertEquals(token, response.jsonPath().get("token"));


    }












}
