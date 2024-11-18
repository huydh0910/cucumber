package com.cucumber.example.api.runner;
import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.api",
        plugin = {
                "pretty",
                "com.cucumber.hooks.CucumberListener",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber-reports.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class ApiTestRunner {
}