package com.quannguyen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By TXT_USERNAME = By.id("UserName");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By BTN_LOGIN = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String username) {
        driver.findElement(TXT_USERNAME).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(TXT_PASSWORD).sendKeys(password);
    }

    public void ClickLoginBtn() {
        driver.findElement(BTN_LOGIN).click();
    }

}
