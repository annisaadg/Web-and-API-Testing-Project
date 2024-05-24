package com.tubes.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@focus",features="src/test/resources",
        glue= {"com.tubes.stepdefinition"},
        plugin ={"pretty","json:target/cucumber.json","html:test-report.html"}
        )
public class TestRunner {
}

