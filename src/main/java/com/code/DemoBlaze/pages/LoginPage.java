package com.code.DemoBlaze.pages;

import com.code.DemoBlaze.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUseNameInput() {
        return this.driver.findElement(By.xpath("//input[@id='loginusername']"));
    }

    public WebElement getPasswordInput() {
        return this.driver.findElement(By.xpath("//input[@id='loginpassword']"));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.xpath("//button[@onclick='logIn()']"));
    }

    public void setUsername(String username) {
        WebElement input = getUseNameInput();
        new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.elementToBeClickable(input));
        input.click();
        input.sendKeys(username);
    }

    public void setPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        getLoginButton().click();
    }

    public void loginUser(User user) {
        login(user.getUserName(), user.getPassword());
    }

}
