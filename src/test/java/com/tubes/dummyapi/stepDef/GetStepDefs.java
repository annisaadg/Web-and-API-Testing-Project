package com.tubes.dummyapi.stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.json.JSONObject;

import java.util.prefs.Preferences;

import com.tubes.dummyapi.logic.APIUserTest;

public class GetStepDefs {

    APIUserTest apiUser;

    JSONObject bodyReq;
    Preferences prefs = Preferences.userNodeForPackage(StepDefs.class);

    public GetStepDefs() {  // Corrected the constructor name
        apiUser = new APIUserTest();
    }

}
