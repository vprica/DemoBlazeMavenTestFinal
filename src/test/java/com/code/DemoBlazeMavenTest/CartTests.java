package com.code.DemoBlazeMavenTest;

import com.code.DemoBlaze.pages.BasePage;
import com.code.DemoBlaze.pages.CartPage;
import com.code.DemoBlaze.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void verifyCartTotalPrice() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        waitPageToLoad();

        double productsPriceSum = homePage.addFirstThreeProductsAndGetTheirPrice();

        CartPage cartPage = homePage.openCart();
        waitPageToLoad();
        String cartPriceAsString = cartPage.getCartPrice();
        double cartPrice = Double.parseDouble(cartPriceAsString);

        Assert.assertEquals(cartPrice, productsPriceSum);
    }

}
