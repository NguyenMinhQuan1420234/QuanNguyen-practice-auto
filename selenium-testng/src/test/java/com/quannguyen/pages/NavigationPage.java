package com.quannguyen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.quannguyen.contents.ConfigConstants;

public class NavigationPage extends BasePage {
    private By LBL_USERNAME = By.id("userName-value");
    private By CLASS_NAME = By.id("userName");
    private By BASEPAGE_APPEAR = By.xpath("//div[@id='app']");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return getText(LBL_USERNAME);
    }

    public String getClassAttribute() {
        return getAttribute(CLASS_NAME, "class");
    }

    // public WebElement waitForElmentToBeVisibile() {
    //     return null;
    // }
}
