package com.quannguyen.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import com.quannguyen.contents.ConfigConstants;
import com.quannguyen.contents.UrlConstants;
import com.quannguyen.pages.BasePage;
import com.quannguyen.pages.HomePage;
import com.quannguyen.pages.LoginPage;
import com.quannguyen.pages.NavigationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.quannguyen.utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

@Listeners({ ExtentIReporterSuiteListenerAdapter.class })
public class LoginTest extends BaseTest {

    public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeMethod
    public void BeforeMethod() {

        // System.setProperty("webdriver.chrome.driver", "C:/Users/banch/TestNG/demo/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        report = new ExtentReports("C:/Users/banch/QuanNguyen-practice-auto/selenium-testng/extent-reports/report.html", true);
        test = report.startTest("Extent report demo");
        driver.get(ConfigConstants.BASE_URL);

    }

    @AfterMethod
    public void AfterMethod() {
        report.endTest(test);
        report.flush();
        driver.close();
    }

    @Test(priority = 0, description = "Login successfully.")
    public void openBrowser(Method method) {
        test.log(LogStatus.INFO, "testing Browser working normally starts.");
        startTest(method.getName(), "Open browser.");
        System.out.println("Checking if browser working right.");

        test.log(LogStatus.PASS, "Browser is working as intend.");

    }

    @Test(priority = 1, description = "Login successfully.")
    public void LoginSuccessfulCase(Method method) throws InterruptedException {
        test.log(LogStatus.INFO, "Test case: Login successfully starts.");

        startTest(method.getName(), "Login with valid username and password.");

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        try {
            loginPage.navigate(UrlConstants.LOGIN_URL);

        } catch (Exception e) {
            //TODO: handle exception
        }

        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword(ConfigConstants.PASSWORD);
        loginPage.ClickLoginBtn();

        assertThat("verify message", navigatePage.getUsername(), equalTo(ConfigConstants.USERNAME));
        test.log(LogStatus.PASS, "Log in successfully");

    }

    @Test(priority = 1, description = "Login Unsuccessfully with empty username and password.")
    public void LoginUnsuccessfully(Method method) {
        test.log(LogStatus.INFO, "Test case: invalid Login starts.");

        startTest(method.getName(), "Login with invalid username and password.");

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.navigate(UrlConstants.LOGIN_URL);
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.ClickLoginBtn();

        assertThat("verify message",  navigatePage.getClassAttribute(), equalTo(ConfigConstants.USERNAME_CLASS_INVALID));
        test.log(LogStatus.PASS, "Log in fail");

    }

}
