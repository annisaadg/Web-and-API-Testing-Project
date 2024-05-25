package com.tubes.dummyapi.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.prefs.Preferences;

import com.tubes.dummyapi.logic.APIUserTest;
import com.tubes.dummyapi.logic.APITestProcessGeneric;
import com.tubes.dummyapi.model.UserProfile;
import com.tubes.dummyapi.helper.SetUpEndPoint;

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
        // prepare end point API
        SetUpEndPoint.prepareURL(endpoint); // prepare end point
    }

    @When("hit api post create new user with app-id {string}")
    public void hitApiPostCreateNewUser(String appid) {
        dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost();
        String userId = apiUser.hitAPIPostNewUser(dataTestCreateUser, appid);  // Capture user ID if needed
        prefs.put("currentUserID", userId);  // Save user ID for later use
    }

    @Then("validation status code api user is equals {int}")
    public void validation_status_code_is_equals(Integer statusCode) {
        // check status response same with param statusCode
        APITestProcessGeneric.validationStatusCode(apiUser.getRes(), statusCode);
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() throws ParseException {
        apiUser.checkResponseBodyCreateUser(dataTestCreateUser);
    }

    @Then("validation response json with JSONSchema {string}")
    public void validation_response_json_with_json_schema(String dataType) {
        APITestProcessGeneric.validationResponseData(apiUser.getRes(), dataType);
    }
}
