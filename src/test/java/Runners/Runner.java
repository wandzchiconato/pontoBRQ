package Runners;

import Steps.acessarPortal;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty"},
        strict = true,
        features = {"src/test/resources/Feature"},
        glue = {"Steps"})
public class Runner {


}


