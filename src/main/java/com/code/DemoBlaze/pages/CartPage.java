package com.code.DemoBlaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {

    }

    public String getCartPrice() {
        WebElement total = driver.findElement(By.xpath("//h3[@id='totalp']"));
        return total.getText();
    }

}
