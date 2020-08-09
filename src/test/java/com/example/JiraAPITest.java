package com.example;

import com.example.payloads.JiraAPIPayloads;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JiraAPITest {

    @Test
    public void addCommentsTest() {

        //SessionFilter records the session id from server and applies it in subsequent requests
        var sessionFilter = new SessionFilter();
        RestAssured.baseURI = "http://localhost:8080";

        //Login
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(JiraAPIPayloads.authenticate())
                .filter(sessionFilter)
                .when()
                .post("rest/auth/1/session")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

        //Add comment to issue/bug
        //Notice how path parameters are added
        var comments = "Adding attachment";
        var addCommentResponse = given()
                .filter(sessionFilter)
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "10002")
                .body(JiraAPIPayloads.addComments(comments))
                .when()
                .post("rest/api/2/issue/{id}/comment")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .response()
                .jsonPath();
        var addCommentId = addCommentResponse.getInt("id");

        //Add Attachment
        //Make sure to allow attachments from Settings menu of Jira
        given()
                .filter(sessionFilter)
                .log().all()
                .header("Content-Type", "multipart/form-data")
                .header("X-Atlassian-Token", "no-check")
                .pathParam("id", "10002")
                .multiPart("file", new File("Library_API.docx"))
                .when()
                .post("/rest/api/2/issue/{id}/attachments")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

        //Get Issue
        //Notice how both query and path parameters are added
        var getIssueResponse = given()
                .filter(sessionFilter)
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "10002")
                .queryParam("fields", "comment")
                .when()
                .get("rest/api/2/issue/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath();

        //Parse Get Issue response to validate comments added
        var noOfComments = getIssueResponse.getInt("fields.comment.comments.size()");
        String actualComments = null;
        for (int i = 0; i < noOfComments; i++) {
            if (getIssueResponse.getInt("fields.comment.comments["+i+"].id") == addCommentId) {
                actualComments = getIssueResponse.getString("fields.comment.comments["+i+"].body");
                break;
            }
        }
        Assert.assertEquals(actualComments, comments);
        System.out.println(actualComments);
        System.out.println(comments);
    }
}
