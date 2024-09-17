package tests.ios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {

    @Test
    public static void validLoginTest() {
        MenuPage menuPage = new MenuPage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        menuPage.navigateToLogin();
        loginPage.login("bob@example.com", "10203040");
        Assert.assertTrue(productPage.waitForProductText());
    }
}
