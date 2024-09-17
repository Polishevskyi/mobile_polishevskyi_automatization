package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    MenuPage menuPage;
    LoginPage loginPage;
    ProductsPage prodPage;

    @Test
    public void ProductValidateTest() throws InterruptedException {
        menuPage = new MenuPage();
        loginPage = new LoginPage();
        prodPage = new ProductsPage();

        Assert.assertEquals(prodPage.getItemsCount(), 6);

        prodPage.sortBy();
        Thread.sleep(1000);
        Assert.assertEquals(prodPage.getFirstProductPrice(), "$29.99");
        Assert.assertEquals(prodPage.getFirstProductName(), "Sauce Labs Backpack");
    }
}
