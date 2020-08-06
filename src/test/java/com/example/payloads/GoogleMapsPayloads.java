package com.example.payloads;

public class GoogleMapsPayloads {

    public static String addPlace() {
        return "{\n" +
                "    \"location\":{\n" +
                "        \"lat\" : -89.383494,\n" +
                "        \"lng\" : 22.427362\n" +
                "    },\n" +
                "    \"accuracy\":50,\n" +
                "    \"name\":\"Parliament Residences\",\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "    \"address\" : \"Parliament St, Toronto\",\n" +
                "    \"types\": [\"Apartment\",\"Buildings\"],\n" +
                "    \"website\" : \"https://www.google.com\",\n" +
                "    \"language\" : \"English\"\n" +
                "}\n";
    }

    public static String updatePlace(String placeId, String newAddress) {
        return "{\n" +
                "\"place_id\":\""+ placeId +"\",\n" +
                "\"address\":\""+ newAddress +"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }

    public static String addBook(String isbn, String aisle) {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }

    public static String sampleJson() {
        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}\n" +
                "\n";
    }
}
