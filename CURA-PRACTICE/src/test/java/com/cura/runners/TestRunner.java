package com.cura.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Test;

@CucumberOptions(features="src/test/java/com/cura/features", glue="com.cura.stepdefinitions", tags="@tag1")
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
