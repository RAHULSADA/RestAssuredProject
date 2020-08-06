package com.example;

import com.example.payloads.GoogleMapsPayloads;
import com.example.utilities.Utilities;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataDrivenTest {

    @Test(dataProvider = "AddBookData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        given()
                .log().all()
                .body(GoogleMapsPayloads.addBook(isbn, aisle))
                .when()
                .post("Library/Addbook.php")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @DataProvider(name = "AddBookData")
    public Object[][] getData() throws IOException {
        return Utilities.readExcel();
    }
}
