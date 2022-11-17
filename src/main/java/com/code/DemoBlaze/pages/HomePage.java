package com.code.DemoBlaze.pages;

import com.code.DemoBlaze.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        this.driver.get("https://www.demoblaze.com/");
        this.driver.manage().window().maximize();
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.xpath("//a[@id='login2']"));
    }

    public WebElement getCartButton() {
        return this.driver.findElement(By.xpath("//a[@id='cartur']"));
    }

    public LoginPage openLoginPage() {
        WebElement loginInButton = getLoginButton();
        loginInButton.click();
        return new LoginPage(this.driver);
    }

    public CartPage openCart() {
        getCartButton().click();
        return new CartPage(driver);
    }

    public WebElement getUserName() {
        return this.driver.findElement(By.xpath("//a[@id='nameofuser']"));
    }

    public List<Product> getAllProducts() {
        List<WebElement> productsList = getProductsList();
        List<Product> products = new ArrayList<Product>();
        for (WebElement webElement : productsList) {
            String productName = webElement.findElement(By.xpath(".//a")).getText();
            String productPrice = webElement.findElement(By.xpath(".//h5")).getText();
            products.add(new Product(productName, productPrice));
        }
        return products;
    }

    public List<WebElement> getProductsList() {
        WebElement productList = this.driver.findElement(By.xpath("//div[@id='tbodyid']"));
        return productList.findElements(By.xpath("//div[@class='card-block']"));
    }

    public void addProductToCart(String productName) {
        WebElement productList = this.driver.findElement(By.xpath("//div[@id='tbodyid']"));
        WebElement product = productList.findElement(By.xpath(".//a[text()='" + productName +"']"));
        product.click();
        waitPageToLoad();
        WebElement addToCartButton = this.driver.findElement(By.xpath(".//a[text()='Add to cart']"));
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.alertIsPresent());
        this.driver.switchTo().alert().accept();
        openPage();
        waitPageToLoad();
    }
    public double addFirstThreeProductsAndGetTheirPrice() {
        List<Product> productList = getAllProducts();
        double productsPriceSum = 0;
        for (int i = 0; i < 3; i++) {
            if (i < productList.size()) {
                Product product = productList.get(i);
                addProductToCart(product.getName());
                productsPriceSum = productsPriceSum + product.getPriceAsDouble();
            }
        }
        return productsPriceSum;
    }

}
