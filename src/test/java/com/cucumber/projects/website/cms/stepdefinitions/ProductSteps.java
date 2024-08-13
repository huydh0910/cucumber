package com.cucumber.projects.website.cms.stepdefinitions;

import com.cucumber.hooks.TestContext;
import com.cucumber.keywords.WebUI;
import com.cucumber.projects.website.cms.pages.CommonPageCMS;
import com.cucumber.projects.website.cms.pages.DashboardPage;
import com.cucumber.projects.website.cms.pages.LoginPage;
import com.cucumber.projects.website.cms.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProductSteps {


    CommonPageCMS commonPageCMS;
    ProductPage productPage;

    public ProductSteps(TestContext testContext) {
        commonPageCMS = testContext.getCommonPage();
        productPage = testContext.getProductPage();
    }

    @Then("User redirect to this page {string}")
    public void userRedirectToThisPage(String name) {
        productPage.verifyProductPageDisplayed();
    }
}
