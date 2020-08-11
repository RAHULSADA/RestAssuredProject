package com.example;

import com.example.pojo.AddPlaceLocationPojo;
import com.example.pojo.AddPlacePojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class POJOSerializationWSpecsBuilder {

    @Test
    public void test() {
        var location = new AddPlaceLocationPojo();
        location.setLat(-55.5555);
        location.setLng(44.1234);

        var rawRequest = new AddPlacePojo();
        rawRequest.setLocation(location);
        rawRequest.setName("650 Parliament");
        rawRequest.setAccuracy(100);
        rawRequest.setPhoneNumber("123-789-7866");
        rawRequest.setAddress("Plot 4, Shyadri Park");
        rawRequest.setWebsite("www.tcs.com");
        rawRequest.setLanguage("German");

        List<String> types = new ArrayList<>();
        types.add("IT");
        types.add("Consulting");
        rawRequest.setTypes(types);

        var request = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType("application/json")
                .addQueryParam("key", "qaclick123")
                .log(LogDetail.ALL)
                .build();

        var response = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();

        var strResponse = given()
                .spec(request)
                .body(rawRequest)
                .when()
                .post("maps/api/place/add/json")
                .then()
                .spec(response)
                .extract()
                .response()
                .asString();
    }

}
