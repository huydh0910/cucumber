package com.cucumber.projects.website.cms.stepdefinitions;

import com.cucumber.hooks.TestContext;
import com.cucumber.keywords.WebUI;
import com.cucumber.projects.website.cms.pages.CommonPageCMS;
import com.cucumber.projects.website.cms.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;
    CommonPageCMS commonPageCMS;

    public LoginSteps(TestContext testContext) {
        loginPage = testContext.getLoginPage();
        commonPageCMS = testContext.getCommonPage();
    }

    @Given("User navigate to Login Page for Admin {string}")
    public void userNavigateToLoginPageForAdmin(String url) {
        WebUI.openWebsite(url);
    }

    @When("user enter email {string} password {string}")
    public void userEnterEmailPasswordAndClickLoginButton(String email, String password) {

        commonPageCMS = loginPage.loginCMS(email, password);
    }

    @When("user enter valid email and valid password")
    public void userEnterValidEmailPasswordAndClickLoginButton() {

        commonPageCMS = loginPage.loginCMS();
    }

    @When("user enter invalid email and valid password")
    public void userEnterInvalidEmailPasswordAndClickLoginButton() {

        String invalid_email = "danghoanghuy.0910@gmail.com";
        String invalid_pass = "123456";
        commonPageCMS = loginPage.loginCMS(invalid_email,invalid_pass);
    }

    @And("click Login button")
    public void clickLoginButton() {
    }

    @Then("user is redirected to the Dashboard page")
    public void userIsRedirectedToTheDashboardPage() {
        commonPageCMS.verifyDashboardPageDisplays();
    }

    @Then("verify popup error is displayed")
    public void verifyErrorNotificationDisplays() {
        loginPage.verifyErrorNotificationDisplays();
    }


}
