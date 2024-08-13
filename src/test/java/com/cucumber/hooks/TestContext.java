package com.cucumber.hooks;

import com.cucumber.driver.DriverManager;
import com.cucumber.driver.TargetFactory;
import com.cucumber.projects.website.cms.pages.CommonPageCMS;
import com.cucumber.projects.website.cms.pages.DashboardPage;
import com.cucumber.projects.website.cms.pages.LoginPage;
import com.cucumber.projects.website.cms.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    public TestContext() {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance());
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    private LoginPage loginPage;
    private CommonPageCMS commonPage;
    private DashboardPage dashboardPage;
    private ProductPage productPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CommonPageCMS getCommonPage() {
        if (commonPage == null) {
            commonPage = new CommonPageCMS();
        }
        return commonPage;
    }

    public DashboardPage getDashboardPage() {

        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ProductPage getProductPage() {

        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}
