package com.example;

import com.example.utilities.Constants;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class OAuthXPOJO {

    @Test
    public void Test() {
//
//        URL given in course is not working, below code will also not work.
//        Refer "OAuth+2+contract-Rest Assured.doc" in project folder for code snippet from course



        var authUrl = Constants.AUTHURL;
        authUrl = authUrl.split("code=")[1];
        var authCode = authUrl.split("&scope=")[0];
//        System.out.println(authUrl);

        //Get Access Token
        var res = given()
                .urlEncodingEnabled(false)
                .queryParams("client_id", Constants.CLIENTID)
                .queryParams("client_secret", Constants.CLIENTSECRET)
                .queryParams("redirect_uri", Constants.REDIRECTURL)
                .queryParams("grant_type", Constants.GRANTTYPE)
                .queryParams("code", authCode)
                .queryParams("scope", Constants.SCOPE)
                .queryParams("state", "state")
                .when()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();

        System.out.println(res);

    }
}
