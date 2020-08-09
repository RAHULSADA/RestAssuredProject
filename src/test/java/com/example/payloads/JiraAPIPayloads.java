package com.example.payloads;

public class JiraAPIPayloads {

    public static String authenticate() {
        return "{\n" +
                "    \"username\": \"RAHULSADA\",\n" +
                "    \"password\": \"Rahul123$\"\n" +
                "}";
    }

    public static String addComments(String comments) {
        return "{\n" +
                "    \"body\": \"" + comments + "\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}";
    }
}
