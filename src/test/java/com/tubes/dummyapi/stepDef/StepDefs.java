package com.tubes.dummyapi.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.json.JSONObject;

import java.text.ParseException;
import java.util.prefs.Preferences;

import com.tubes.dummyapi.logic.APIUserTest;
import com.tubes.dummyapi.logic.APIRequestProcessor;
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

    @Given("I set up the URL for {string}")
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

    @Given("I load user profile data from JSON file {string}")
    public void a_JSON_file_with_user_profile_data(String jsonFilePath) {
        dataTestCreateUser = APIRequestProcessor.prepareDataUserTestPostFromJson(jsonFilePath);
    }


    @When("I send a POST request with the user data")
    public void hitPostCreateNewUserValid() {
        // check status response same with param statusCode
        String userId = apiUser.hitAPIPostNewUser(dataTestCreateUser);  // Capture user ID if needed
        prefs.put("currentUserID", userId);  // Save user ID for later use
    }

    @Then("The API response status code should be {int}")
    public void validation_status_code_is_equals(Integer statusCode) {
        APIRequestProcessor.validationStatusCode(apiUser.getRes(), statusCode);
    }

    @Then("The response body should match the expected user creation schema with {string} field data")
    public void validationResponseBodyPostCreateNewUser(String dataType) throws ParseException {
        switch (dataType) {
            case "full":
                apiUser.checkResponseBodyCreateUser(dataTestCreateUser);
                APIRequestProcessor.validationResponseData(apiUser.getRes(), "post_create_user_normal.json");
                break;
            case "required":
                apiUser.checkResponseBodyCreateUserRequired(dataTestCreateUser);
                APIRequestProcessor.validationResponseData(apiUser.getRes(), "post_half_user.json");
                break;
            default:
                break;
        }
    }

    @When("I prepare the app-id {string}")
    public void i_prepare_for_app_id(String appid) {
        RequestAPIUserManagement.setUpHeader(appid);
    }
}
