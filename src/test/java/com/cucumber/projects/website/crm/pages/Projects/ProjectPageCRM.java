package com.cucumber.projects.website.crm.pages.Projects;

import com.cucumber.common.CommonPageCRM;
import com.cucumber.keywords.WebUI;
import org.openqa.selenium.By;

public class ProjectPageCRM extends CommonPageCRM {

    public ProjectPageCRM() {
    }

    private final String pageText = "Projects";

    //Project Page Element
    private final By projectMenu = By.xpath("//span[normalize-space()='Projects']");
    private final By searchInput = By.xpath("//input[@type='search']");

    public void searchByValue(String value) {
        WebUI.clearText(searchInput);
        WebUI.setText(searchInput, value);
        WebUI.sleep(1);
    }

}
