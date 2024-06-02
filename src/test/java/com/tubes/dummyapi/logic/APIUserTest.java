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

    public String hitAPIPostNewUser(UserProfile dataUser) {
        res = RequestAPIUserManagement.postCreateUser(SetUpEndPoint.getURL(), dataUser); //call API Post New User
        System.out.println(res.getBody().asString()); // logging response API

        return res.getBody().jsonPath().get("id");
    }

    public String hitAPIGetUser(String userId) {
        res = RequestAPIUserManagement.getUserById(SetUpEndPoint.getURL(), userId); //call API Get User by Id
        System.out.println(res.getBody().asString()); // logging response API

        return res.getBody().jsonPath().get("id");
    }

    public String hitAPIDeleteUser(String userId) {
        res = RequestAPIUserManagement.deleteUserById(SetUpEndPoint.getURL(), userId); //call API Get User by Id
        System.out.println(res.getBody().asString()); // logging response API

        return res.getBody().jsonPath().get("id");
    }

    public void checkResponseBodyCreateUserFailed(String expectedMessage) {
        System.out.println("validation response body profile user process failed");
        JSONObject notification = new JSONObject(res.getBody().asString()); // get data json in object

        // verify data
        String actualMessage = notification.get("error").toString();
        System.out.println("actual message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
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
        Assert.assertEquals(actualData.getLocation().getStreet(), dataTestUser.getLocation().getStreet());
        Assert.assertEquals(actualData.getLocation().getCity(), dataTestUser.getLocation().getCity());
        Assert.assertEquals(actualData.getLocation().getState(), dataTestUser.getLocation().getState());
        Assert.assertEquals(actualData.getLocation().getCountry(), dataTestUser.getLocation().getCountry());
        Assert.assertEquals(actualData.getLocation().getTimezone(), dataTestUser.getLocation().getTimezone());
        
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

    public void checkResponseBodyCreateUserRequired(UserProfile dataTestUser) throws ParseException {
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

    public void checkResponseBodyGetUser(String userId) throws ParseException {
        System.out.println("test logic for check response body get user");
        
        // Inisialisasi Gson
        Gson json = new Gson();
        
        // Mendapatkan data aktual dari respons HTTP dan mengonversinya menjadi objek UserProfile
        UserProfile actualData = json.fromJson(res.getBody().asString(), UserProfile.class);
        
        // Mencetak data aktual dan data pengujian
        System.out.print("Actual Data : ");
        System.out.println(json.toJson(actualData));
        System.out.print("Test Data User Id : ");
        System.out.println(userId);
        
        // Memerika setiap atribut data aktual ditampilkan
        Assert.assertEquals(actualData.getId(), userId);
        Assert.assertNotNull(actualData.getTitle());
        Assert.assertNotNull(actualData.getFirstName());
        Assert.assertNotNull(actualData.getLastName());
        Assert.assertNotNull(actualData.getPicture());
        Assert.assertNotNull(actualData.getGender());
        Assert.assertNotNull(actualData.getEmail());
        Assert.assertNotNull(actualData.getDateOfBirth());
        Assert.assertNotNull(actualData.getPhone());
        Assert.assertNotNull(actualData.getLocation().getStreet());
        Assert.assertNotNull(actualData.getLocation().getCity());
        Assert.assertNotNull(actualData.getLocation().getState());
        Assert.assertNotNull(actualData.getLocation().getCountry());
        Assert.assertNotNull(actualData.getLocation().getTimezone());
        Assert.assertNotNull(actualData.getRegisterDate());
        Assert.assertNotNull(actualData.getUpdatedDate());
    }

    public void checkResponseBodyDeleteUser(String userId) {
       
        // Inisialisasi Gson
        Gson json = new Gson();
        
        // Mendapatkan data aktual dari respons HTTP dan mengonversinya menjadi objek UserProfile
        UserProfile actualData = json.fromJson(res.getBody().asString(), UserProfile.class);
        
        // Mencetak data aktual dan data pengujian
        System.out.print("Actual Data : ");
        System.out.println(json.toJson(actualData));
        System.out.print("Test Data User Id : ");
        System.out.println(userId);

        // Memerika id pada response body
        Assert.assertEquals(actualData.getId(), userId);

    }

 }
