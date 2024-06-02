package com.tubes.websaucedemo.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/websaucedemo/features",
        glue= {"com.tubes.websaucedemo.stepdefinition"},
        plugin ={"pretty","json:target/cucumber.json","html:test-report.html"}
        )
public class WebTestRunner {
}

