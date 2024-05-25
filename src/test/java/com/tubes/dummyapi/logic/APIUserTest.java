package com.tubes.dummyapi.logic;

import com.tubes.dummyapi.model.UserProfile;
import com.google.gson.Gson;
import com.tubes.dummyapi.helper.SetUpEndPoint;
import com.tubes.dummyapi.logic.request.RequestAPIUserManagement;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class APIUserTest {

    private Response res;

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public void checkResponseBodyProfileUser() {
        System.out.println("validation response body profile user process normal");
        JSONObject userProfile = new JSONObject(res.getBody().asString()); // get data json in object

        // verify data
        Assert.assertNotNull(userProfile.get("id"));
        // assertThat(userProfile.get("title")).isIn("mr", "ms", "mrs", "miss", "dr", ""); // check title value between mr, ms, mrs, miss, dr, and blank
        Assert.assertNotNull(userProfile.get("firstName")); // check first name not null
        Assert.assertNotNull(userProfile.get("lastName")); // check last name not null
        // assertThat(userProfile.get("gender")).isIn("male", "female", ""); // check gender value between male, female, and blank
    }

    public String hitAPIPostNewUser(UserProfile dataUser, String appid) {
        res = RequestAPIUserManagement.postCreateUser(SetUpEndPoint.getURL(), dataUser, appid); //call API Post New User
        System.out.println(res.getBody().asString()); // logging response API

        return res.getBody().jsonPath().get("id");
    }

    public void checkResponseBodyCreateUser(UserProfile dataTestUser) throws ParseException {
        System.out.println("test logic for check response body create user");
        
        // Inisialisasi Gson
        Gson json = new Gson();
        
        // Mendapatkan data aktual dari respons HTTP dan mengonversinya menjadi objek UserProfile
        UserProfile actualData = json.fromJson(res.getBody().asString(), UserProfile.class);
        
        // Mencetak data aktual dan data pengujian
        System.out.print("Actual Data : ");
        System.out.println(json.toJson(actualData));
        System.out.print("Test Data : ");
        System.out.println(json.toJson(dataTestUser));
        
        // Membandingkan setiap atribut dari data pengguna aktual dengan data pengguna pengujian
        Assert.assertEquals(actualData.getTitle(), dataTestUser.getTitle());
        Assert.assertEquals(actualData.getFirstName(), dataTestUser.getFirstName());
        Assert.assertEquals(actualData.getLastName(), dataTestUser.getLastName());
        Assert.assertEquals(actualData.getPicture(), dataTestUser.getPicture());
        Assert.assertEquals(actualData.getGender(), dataTestUser.getGender());
        Assert.assertEquals(actualData.getEmail(), dataTestUser.getEmail());
        Assert.assertEquals(actualData.getDateOfBirth(), dataTestUser.getDateOfBirth());
        Assert.assertEquals(actualData.getPhone(), dataTestUser.getPhone());
        // Assert.assertEquals(actualData.getLocation().getStreet(), dataTestUser.getLocation().getStreet());
        // Assert.assertEquals(actualData.getLocation().getCity(), dataTestUser.getLocation().getCity());
        // Assert.assertEquals(actualData.getLocation().getState(), dataTestUser.getLocation().getState());
        // Assert.assertEquals(actualData.getLocation().getCountry(), dataTestUser.getLocation().getCountry());
        // Assert.assertEquals(actualData.getLocation().getTimezone(), dataTestUser.getLocation().getTimezone());
        
        // Mendefinisikan format tanggal
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        
        // Mendapatkan tanggal hari ini
        Date currentDate = new Date();
        String currentDateStr = sdfDate.format(currentDate);
        
        // Membandingkan tanggal register dan updated dengan tanggal hari ini
        Assert.assertEquals(currentDateStr, sdfDate.format(sdfTime.parse(actualData.getRegisterDate())));
        Assert.assertEquals(currentDateStr, sdfDate.format(sdfTime.parse(actualData.getUpdatedDate())));
    }

 }
