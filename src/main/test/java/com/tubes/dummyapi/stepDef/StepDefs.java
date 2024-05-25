package com.tubes.dummyapi.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import org.json.JSONObject;

import java.text.ParseException;
import java.util.prefs.Preferences;

import com.tubes.dummyapi.logic.APIUserTest;
import com.tubes.dummyapi.logic.request.EndPoint;
import com.tubes.dummyapi.logic.APITestProcessGeneric;
import com.tubes.dummyapi.model.UserProfile;
import com.tubes.dummyapi.helper.SetUpEndPoint;
import com.tubes.dummyapi.logic.request.RequestAPIUserManagement;

public class StepDefs {

    APIUserTest apiUser;
    UserProfile dataTestCreateUser, dataTestUpdateUser;
    String currentUserID;

    JSONObject bodyReq;
    Preferences prefs = Preferences.userNodeForPackage(StepDefs.class);

    public StepDefs() {  // Corrected the constructor name
        apiUser = new APIUserTest();
    }

    @Given("prepare url for {string}")
    public void prepare_url_for(String endpoint) {
        String endpointConstant;
        
        switch(endpoint) {
            case "create new user":
                endpointConstant = "CREATE_NEW_USER";
                break;
            case "get users list" :
                endpointConstant = "GET_LIST_USERS";
                break;
            case "get user by id" :
                endpointConstant = "GET_PROFILE_USER";
                break;
            case "update user" :
                endpointConstant =  "UPDATE_USER";
                break;
            case "delete user" :
                endpointConstant = "DELETE_USER";
                break;
            default:
                System.out.println("Error: Invalid endpoint provided.");
                return;
        }
        
        SetUpEndPoint.prepareURL(endpointConstant);
    }

    @When("enter request data with firstname {string}, lastname {string}, and email {string}")
    public void hitApiPostCreateNewUser(String firstname, String lastname, String email) {
        dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost(firstname, lastname, email);
    }

    @When("i send the POST request with valid user data input")
    public void hitPostCreateNewUserValid() {
        // check status response same with param statusCode
        String userId = apiUser.hitAPIPostNewUser(dataTestCreateUser);  // Capture user ID if needed
        prefs.put("currentUserID", userId);  // Save user ID for later use
    }

    @Then("validation status code api user is equals {int}")
    public void validation_status_code_is_equals(Integer statusCode) {
        APITestProcessGeneric.validationStatusCode(apiUser.getRes(), statusCode);
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() throws ParseException {
        apiUser.checkResponseBodyCreateUser(dataTestCreateUser);
        APITestProcessGeneric.validationResponseData(apiUser.getRes(), "post_half_user.json");
    }

    @When("i prepare for app-id {string}")
    public void i_prepare_for_app_id(String appid) {
        RequestAPIUserManagement.setUpHeader(appid);
    }
}
