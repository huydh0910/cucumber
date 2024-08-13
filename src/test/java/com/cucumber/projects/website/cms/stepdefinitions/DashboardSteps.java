package com.cucumber.projects.website.cms.stepdefinitions;

import com.cucumber.hooks.TestContext;
import com.cucumber.keywords.WebUI;
import com.cucumber.projects.website.cms.pages.CommonPageCMS;
import com.cucumber.projects.website.cms.pages.DashboardPage;
import com.cucumber.projects.website.cms.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {

    LoginPage loginPage;
    CommonPageCMS commonPageCMS;
    DashboardPage dashboardPage;

    public DashboardSteps(TestContext testContext) {
        loginPage = testContext.getLoginPage();
        commonPageCMS = testContext.getCommonPage();
        dashboardPage = testContext.getDashboardPage();
    }

    @Given("User navigate to dashboard")
    public void userNavigateDefaultDashboard() {
        dashboardPage.verifyDashboardElementDisplayed();
    }
}
