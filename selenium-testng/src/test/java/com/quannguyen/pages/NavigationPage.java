package com.quannguyen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.quannguyen.contents.ConfigConstants;

public class NavigationPage extends BasePage {
    private By LBL_USERNAME = By.id("userName-value");
    private By CLASS_NAME = By.id("userName");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return getText(LBL_USERNAME);
    }

    public String getClassAttribute() {
        return getAttribute(CLASS_NAME, "class");
    }

}
