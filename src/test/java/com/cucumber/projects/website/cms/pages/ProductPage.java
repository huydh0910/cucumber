package com.cucumber.projects.website.cms.pages;

import com.cucumber.keywords.WebUI;
import org.openqa.selenium.By;


public class ProductPage {

//    String header = "//h5[.='%s']";
    private By header = By.xpath("//h5[.='Add New Product']");

    public void verifyProductPageDisplayed() {
        WebUI.verifyElementPresent(header);
    }
}
