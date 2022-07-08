package com.quannguyen.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By TXT_USERNAME = By.id("userName");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By BTN_LOGIN = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsername(String username) {
        inputText(TXT_USERNAME, username);
    }

    public void inputPassword(String password) {
        inputText(TXT_PASSWORD, password);
    }

    public void ClickLoginBtn() {
        clickElement(BTN_LOGIN);   
    }

}
