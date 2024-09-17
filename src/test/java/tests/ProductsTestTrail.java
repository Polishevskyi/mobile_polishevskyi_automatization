package tests;

import base.BaseTest;
import driver.AppDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class ProductsTestTrail extends BaseTest {

    MenuPage menuPage;
    LoginPage loginPage;
    ProductsPage prodPage;

    @Test
    public void ProductValidateTest() throws InterruptedException {
        menuPage = new MenuPage();
        loginPage = new LoginPage();
        prodPage = new ProductsPage();

        AppDriver.getCurrentDriver().findElement(prodPage.fifthItem).click();
//        AppDriver.getCurrentDriver().findElement(prodPage.footer).click();

       /* Assert.assertEquals(prodPage.getItemsCount(), 6);

        prodPage.sortBy();
        Thread.sleep(1000);
        Assert.assertEquals(prodPage.getFirstProductPrice(), "$29.99");
        Assert.assertEquals(prodPage.getFirstProductName(), "Sauce Labs Backpack");

        */
    }
}
