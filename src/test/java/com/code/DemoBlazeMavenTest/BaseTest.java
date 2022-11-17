package com.code.DemoBlazeMavenTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prica\\Downloads\\chromedriver_win32 (3)//chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    public void waitPageToLoad() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofMillis(6000));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        wait.until(webDriver -> (long)((JavascriptExecutor)webDriver).executeScript("return jQuery.active") == 0 );
    }

}
