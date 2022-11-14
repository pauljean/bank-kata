package com.pauljean.bankkata.service.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/html/test-result.html"},
        features = {"src/test/resources"},
        glue = "com.pauljean.bankkata.service.bdd"
)
public class TestRunner {

}


