package com.quannguyen.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import com.quannguyen.contents.ConfigConstants;
import com.quannguyen.contents.UrlConstants;
import com.quannguyen.pages.BasePage;
import com.quannguyen.pages.HomePage;
import com.quannguyen.pages.LoginPage;
import com.quannguyen.pages.NavigationPage;

import java.time.Duration;

import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static com.quannguyen.utils.extentreports.ExtentTestManager.startTest;

@Listeners(ExtentIReporterSuiteListenerAdapter.class)
public class LoginTest extends BaseTest {

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

    @Test(priority = 1, description = "Login successfully.")
    public void LoginSuccessfulCase(Method method) {

        startTest(method.getName(), "Login with valid username and password.");

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.navigate(UrlConstants.LOGIN_URL);
        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword(ConfigConstants.PASSWORD);
        loginPage.ClickLoginBtn();

        assertThat("verify message", navigatePage.getUsername(), equalTo(ConfigConstants.USERNAME));
    }

    @Test(priority = 1, description = "Login Unsuccessfully with empty username and password.")
    public void LoginUnsuccessfully(Method method) {

        startTest(method.getName(), "Login with invalid username and password.");

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.navigate(UrlConstants.LOGIN_URL);
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.ClickLoginBtn();
        String name = navigatePage.getClassAttribute();
        System.out.println("name");
        // assertThat("verify message", navigatePage., equalTo(ConfigConstants.INVALID_CLASS_VALUE));
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
