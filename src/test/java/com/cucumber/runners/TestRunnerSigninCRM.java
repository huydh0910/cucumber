package com.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/SigninCRM.feature",
        glue = {
                "com.cucumber.projects.website.crm.stepdefinitions",
                "com.cucumber.hooks"
        },
        plugin = {
                "com.cucumber.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/TestRunnerSigninCRM.html",
                "json:target/cucumber-reports/TestRunnerSigninCRM.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@Regression or @Smoke"
)

public class TestRunnerSigninCRM extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
