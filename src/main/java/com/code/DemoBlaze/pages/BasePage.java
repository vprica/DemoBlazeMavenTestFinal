package com.code.DemoBlaze.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void openPage();

    public void waitPageToLoad() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(6000));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        wait.until(webDriver -> (long)((JavascriptExecutor)webDriver).executeScript("return jQuery.active") == 0 );
    }

}
