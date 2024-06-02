package com.tubes.dummyapi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@get-positive",
        glue = {"com.tubes.dummyapi.stepDef"},
        features = {"src/test/resources/dummyapi/features"},
        plugin = {
                "pretty",
                "html:reports/test-report-api.html"
        }
)
public class APITestRunner {}