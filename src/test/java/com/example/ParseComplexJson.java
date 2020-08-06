package com.example;

import com.example.payloads.GoogleMapsPayloads;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class ParseComplexJson {

    @Test
    public void parseJason() {
        var jsonPath = new JsonPath(GoogleMapsPayloads.sampleJson());

        //No of courses returned by API
        var courseCount = jsonPath.getList("courses").size();
        System.out.println(courseCount);
        System.out.println(jsonPath.getInt("courses.size()"));

        //Print purchase amount
        System.out.println(jsonPath.getInt("dashboard.purchaseAmount"));

        //Print title of first course
        System.out.println(jsonPath.getString("courses[0].title"));

        //Print all course titles and their price
        for (int i = 0; i < courseCount; i++) {
            System.out.println(jsonPath.getString("courses["+i+"].title"));
            System.out.println(jsonPath.getInt("courses["+i+"].price"));
        }
    }
}
