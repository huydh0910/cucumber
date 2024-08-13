package com.cucumber.projects.website.cms.pages;

import com.cucumber.keywords.WebUI;
import org.openqa.selenium.By;


public class DashboardPage {

    String cards = "//*[@class='card']//*[.='%s']";
    public void verifyDashboardElementDisplayed() {
        String xpathCardProduct = String.format(cards, "Products");
        String xpathCardSellers = String.format(cards, "Sellers");
        String xpathCardCatSale = String.format(cards, "Category wise product sale");
        String xpathCardCatStock = String.format(cards, "Category wise product stock");

        WebUI.verifyElementPresent(By.xpath(xpathCardProduct));
        WebUI.verifyElementPresent(By.xpath(xpathCardSellers));
        WebUI.verifyElementPresent(By.xpath(xpathCardCatSale));
        WebUI.verifyElementPresent(By.xpath(xpathCardCatStock));

    }
}
