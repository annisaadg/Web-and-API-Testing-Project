package com.tubes.dummyapi.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.tubes.dummyapi.stepDef"},
        features = {"src/test/resources/dummyapi/features"},
        plugin = {
                "pretty",
                "html:reports/test-report-api.html"
        },
        tags = "@put"
)
public class APITestRunner {}