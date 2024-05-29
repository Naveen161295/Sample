package org.Utility;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = "src/test/resources/FeatureFiles",
		glue= {"org.stepDefinitions"},
		monochrome= true,
		dryRun = false,
		plugin = {"pretty"},
		snippets = SnippetType.CAMELCASE
		
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
