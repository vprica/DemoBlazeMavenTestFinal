package com.code.DemoBlazeMavenTest;

import com.code.DemoBlaze.models.User;
import com.code.DemoBlaze.pages.HomePage;
import com.code.DemoBlaze.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void verifyIfLoginIsSuccessful() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.loginUser(new User("test","test"));
        waitPageToLoad();
        Assert.assertTrue(homePage.getUserName().isDisplayed());
    }

}
