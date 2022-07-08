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
        driver.get(ConfigConstants.BASE_URL + url);
    }

    public WebElement waitForElmentToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElmentToBeVisibile(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

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
 
}
