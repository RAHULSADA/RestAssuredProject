package com.example;

import com.example.payloads.GoogleMapsPayloads;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        //All requests are sent in given, when, then format
        //given() -> parameters, headers, payload
        //when() -> request type and resource
        //then() -> validations
        //log -> optional, added to record logs
        //import static package for using given()
        given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(GoogleMapsPayloads.addPlace())
                .when()
                .post("maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                //import static hamcrest package to use equalTo method
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)");
    }
}
