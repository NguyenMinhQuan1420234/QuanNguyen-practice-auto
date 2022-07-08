package com.quannguyen.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quannguyen.contents.ConfigConstants;
import com.quannguyen.contents.UrlConstants;
import com.quannguyen.pages.LoginPage;
import com.quannguyen.pages.NavigationPage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;

    @BeforeMethod
    public void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigConstants.BASE_URL);
    }

    @Test
    public void openBrowser() {
        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.navigate(UrlConstants.LOGIN_URL);
        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword(ConfigConstants.PASSWORD);
        loginPage.ClickLoginBtn();
        assertThat("verify message", navigatePage.getUsername(), equalTo(ConfigConstants.USERNAME));
    }
}
