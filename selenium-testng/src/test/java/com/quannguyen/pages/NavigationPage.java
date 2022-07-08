package com.quannguyen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    private By LBL_USERNAME = By.id("userName-value");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return getText(LBL_USERNAME);
    }

}
