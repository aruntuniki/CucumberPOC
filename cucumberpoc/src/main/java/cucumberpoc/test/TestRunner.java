package cucumberpoc.test;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports.html",
				"json:target/cucumber.json"}
		
		
//    features = "Features", // folder name
//    glue = "stepDefinition" // package name
)
public class TestRunner {
}