package com.tubes.dummyapi.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tubes.dummyapi.model.UserProfile;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

public class APIRequestProcessor {

    /* check response data in application JSONSchema */
    public static void validationResponseData(Response currentRes, String data){
        System.out.println("check response data : " + data);
        File fileUsersJson = getJSONSchemaFile(data);
        currentRes.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(fileUsersJson));
    }

    private static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/resources/dummyapi/schema/" + JSONFile);
    }

    /* check status code response same with status code expected */
    public static void validationStatusCode(Response currentRes, int expectedStatusCode){
        System.out.println("check status code : " + expectedStatusCode);
        Assert.assertEquals(expectedStatusCode, currentRes.getStatusCode());
    }

    public static UserProfile prepareDataUserTestPostFromJson(String jsonFilePath) {
        try {
            // Baca data dari file JSON
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(jsonFilePath);
            return objectMapper.readValue(file, UserProfile.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
