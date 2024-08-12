package com.cucumber.projects.website.cms.pages;

import com.cucumber.keywords.WebUI;
import org.openqa.selenium.By;

public class LoginPage {

    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By buttonCopy = By.xpath("//button[normalize-space()='Copy']");
    private By errorCredencial = By.xpath("//div [@data-notify='container']");

    public CommonPageCMS loginCMS(String email, String password) {
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);

        return new CommonPageCMS();
    }

    public CommonPageCMS loginCMS() {
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);

        return new CommonPageCMS();
    }

    public void verifyErrorNotificationDisplays() {
        WebUI.verifyElementPresent(errorCredencial);
    }

}
