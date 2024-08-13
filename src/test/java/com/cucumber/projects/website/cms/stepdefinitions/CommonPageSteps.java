package com.cucumber.projects.website.cms.stepdefinitions;

import com.cucumber.hooks.TestContext;
import com.cucumber.keywords.WebUI;
import com.cucumber.projects.website.cms.pages.CommonPageCMS;
import com.cucumber.projects.website.cms.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonPageSteps {

    LoginPage loginPage;
    CommonPageCMS commonPageCMS;

    public CommonPageSteps(TestContext testContext) {
        loginPage = testContext.getLoginPage();
        commonPageCMS = testContext.getCommonPage();
    }

    @When("User click menu {string}")
    public void userClickMenu(String name) {
        commonPageCMS.clickToSideMenuItem(name);
    }

    @When("User click menu {string} and {string}")
    public void userClickMenuAnd(String root, String name) {
        commonPageCMS.clickToSideMenuItem(root);
        commonPageCMS.clickToSideMenuSubItem(root, name);
    }
}
