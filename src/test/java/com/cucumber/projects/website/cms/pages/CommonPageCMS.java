package com.cucumber.projects.website.cms.pages;

import com.cucumber.keywords.WebUI;
import io.cucumber.messages.types.Product;
import org.openqa.selenium.By;

import static com.cucumber.keywords.WebUI.*;

public class CommonPageCMS {

    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    String sideMenuItem = "//*[@id='main-menu']//*[text()='%s']";
    String sideMenuSubItem = "//*[@id='main-menu']//*[text()='%s']/../..//li[contains(.,'%s')]";
    public void verifyDashboardPageDisplays() {
        waitForPageLoaded();
        verifyContains(getCurrentUrl(), "/admin", "The URL not match.");
        verifyElementPresent(menuProducts, 5, "Login failed. The Dashboard page not displays.");
    }

    public void clickToSideMenuItem(String name){
        String xpath = String.format(sideMenuItem, name);
        waitForElementPresent(By.xpath(xpath));
        WebUI.clickElement(By.xpath(xpath));
    }

    public void clickToSideMenuSubItem(String root, String name){
        String xpath = String.format(sideMenuItem, root);
        waitForElementPresent(By.xpath(xpath));
        String xpathSubItem = String.format(sideMenuSubItem, root, name);
        waitForElementPresent(By.xpath(xpathSubItem));
        WebUI.clickElement(By.xpath(xpathSubItem));
    }

}
