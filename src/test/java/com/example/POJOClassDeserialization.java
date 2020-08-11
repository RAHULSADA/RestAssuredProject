package com.example;

import com.example.payloads.JiraAPIPayloads;
import com.example.pojo.GetUserPojo;
import io.restassured.filter.session.SessionFilter;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POJOClassDeserialization {

    @Test
    public void getIssue() {

        var sessionFilter = new SessionFilter();

        //login
        given()
                .filter(sessionFilter)
                .header("Content-Type", "application/json")
                .body(JiraAPIPayloads.authenticate())
                .when()
                .post("http://localhost:8080/rest/auth/1/session")
                .then()
                .assertThat()
                .statusCode(200);

        //Get User
        var getUserResponse = given()
                .filter(sessionFilter)
                .queryParam("username", "RAHULSADA")
                .expect()
                .defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:8080/rest/api/2/user")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .as(GetUserPojo.class);

        System.out.println(getUserResponse.getDisplayName());
        System.out.println(getUserResponse.getKey());
        System.out.println(getUserResponse.getAvatarUrls().get("24x24"));
        System.out.println(getUserResponse.getGroups().getSize());
        System.out.println(getUserResponse.getApplicationRoles().getItems());
    }
}
