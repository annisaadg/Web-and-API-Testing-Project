package com.tubes.dummyapi.logic.request;

import com.tubes.dummyapi.model.UserProfile;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestAPIUserManagement {
    private static RequestSpecification request;

    public static void setUpHeader(String appId){
        request = RestAssured.given()
                .header("Content-Type", "application/json") // set the header to accept json
                .header("Accept", "application/json")
                .header("app-id", appId);
    }

    public static Response postCreateUser(String endpoint, UserProfile dataUser) {
        // create data with json format
        Gson payload = new Gson();
        System.out.println("Gson :" + payload.toJson(dataUser));
        return request.body(payload.toJson(dataUser)).when().post(endpoint); // call API create user
    }

    public static Response getUserById(String endpoint, String userIdParams) {
        return request.get(endpoint + userIdParams);
    }

    public static Response deleteUserById(String endpoint, String userIdParams) {
        return request.delete(endpoint + userIdParams);
    }


}