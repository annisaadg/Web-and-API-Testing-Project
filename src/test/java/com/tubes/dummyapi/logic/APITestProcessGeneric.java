package com.tubes.dummyapi.logic;

import com.tubes.dummyapi.helper.Utility;
import com.tubes.dummyapi.model.Location;
import com.tubes.dummyapi.model.UserProfile;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

public class APITestProcessGeneric {

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

    public static UserProfile prepareDataUserTestPost() {
        UserProfile dataUser = new UserProfile();
        // Location dataLocation   = new Location();

        // information user
        // String title        = "miss";
        // String firstName    = "Alyssa";
        // String lastName     = "Struick";
        // String picture      = "https://randomuser.me/api/portraits/med/women/89.jpg";
        // String gender       = "female";
        // String email        = ""; // generate email
        // String dateOfBirth  = "1945-11-17T06:31:57.367Z";
        // String phone        = "087-368-211";

        // dataUser.setTitle(title);
        // dataUser.setFirstName(firstName);
        // dataUser.setLastName(lastName);
        // dataUser.setPicture(picture);
        // dataUser.setGender(gender);
        // dataUser.setEmail(email);
        // dataUser.setDateOfBirth(dateOfBirth);
        // dataUser.setPhone(phone);

        // // location
        // String street       = "Khayalan";
        // String city         = "Osaka";
        // String state        = "Joseon";
        // String country      = "Japan";
        // String timezone     = "+7:00";

        // dataLocation.setStreet(street);
        // dataLocation.setCity(city);
        // dataLocation.setState(state);
        // dataLocation.setCountry(country);
        // dataLocation.setTimezone(timezone);
        // dataUser.setLocation(dataLocation);

        String firstName    = "Alyssa";
        String lastName     = "Struick";
        String email        = Utility.generateRandomEmail(); // generate email

        dataUser.setFirstName(firstName);
        dataUser.setLastName(lastName);
        dataUser.setEmail(email);

        return dataUser;
    }

}
