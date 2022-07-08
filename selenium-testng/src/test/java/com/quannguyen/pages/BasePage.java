package com.quannguyen.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
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
        driver.get(url);
    }
}
