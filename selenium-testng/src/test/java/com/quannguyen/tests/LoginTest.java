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

import com.quannguyen.pages.LoginPage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openBrowser() throws InterruptedException{
        loginPage = new LoginPage(driver);
        loginPage.navigate(url);
        driver.get("https://demoqa.com/login");

    }
}
