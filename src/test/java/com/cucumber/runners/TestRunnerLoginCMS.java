package com.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/LoginCMS.feature",
        glue = {
                "com.cucumber.projects.website.cms.stepdefinitions",
                "com.cucumber.hooks"
        },
        plugin = {
                "com.cucumber.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/TestRunnerLoginCMS.html",
                "json:target/cucumber-reports/TestRunnerLoginCMS.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        //tags = "@Regression or @Smoke"
        tags = "@Regression"
)

public class TestRunnerLoginCMS extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
