package com.example;

import com.example.payloads.GoogleMapsPayloads;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GoogleMaps {

    @Test
    public void e2eTest() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //AddPlace
        var addPlaceResponse = given()
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
                .extract()
                .response()
                .jsonPath();

        var placeId = addPlaceResponse.getString("place_id");

        //UpdatePlace
        var updatedAddress = "555 Sherbourne Street, M4X1W6";
        given()
                .log().all()
                .queryParam("key", "qaclick123")
                .body(GoogleMapsPayloads.updatePlace(placeId, updatedAddress))
                .when()
                .put("maps/api/place/update/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        //GetPlace
        var address = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get("maps/api/place/get/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath();

        //Validate that address is updated
        Assert.assertEquals(address.getString("address"), updatedAddress);
    }

}
