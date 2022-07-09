package com.quannguyen.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quannguyen.contents.ConfigConstants;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigConstants.TIMEOUT_IN_SECOND));
    }

    public void navigate(String url) {
        // try {
        //     Thread.sleep(5000);
        //     driver.get(ConfigConstants.BASE_URL + url);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        driver.get(ConfigConstants.BASE_URL + url);

    }

    // public void click(By by) {
    //     waitVisibility(by).click();
    // }

    public void inputText(By locator, String text) {
        WebElement element = waitForElmentToBeClickable(locator);
        element.sendKeys(text);
    }

    public void clickElement(By locator) {
        WebElement element = waitForElmentToBeClickable(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = waitForElmentToBeVisibile(locator);
        return element.getText();
    }

    public String getAttribute(By locator, String attribute) {
        WebElement element = waitForElmentToBeVisibile(locator);
        return element.getAttribute(attribute);
    }

    public WebElement waitForElmentToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElmentToBeVisibile(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // public WebElement waitVisibility(By by) {
    //     return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    // }
 
}
