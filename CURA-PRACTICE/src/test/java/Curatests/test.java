package Curatests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(features="src/test/java/Features/input1.feature", glue="StepDefinitions", tags="@tag1")
public class test extends AbstractTestNGCucumberTests {
	
}
