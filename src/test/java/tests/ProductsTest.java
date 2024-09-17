package tests;

import base.BaseTest;
import base.ExcelReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    MenuPage menuPage;
    LoginPage loginPage;
    ProductsPage prodPage;

    @Test
    public void ProductValidateTest() throws Exception {
        menuPage = new MenuPage();
        loginPage = new LoginPage();
        prodPage = new ProductsPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(prodPage.getItemsCount(), 6);

        ExcelReader excelReader = new ExcelReader();
        excelReader.setExcelFile("./testData.xlsx", "prodsort");

        Object obj[][] = excelReader.to2DArray();
        //name, price, sortoption
        for (int i = 0; i < obj.length; i++) {
            prodPage.sortBy(obj[i][2].toString()); //passing the sort option

            softAssert.assertEquals(prodPage.getFirstProductPrice(), obj[i][1].toString());
            softAssert.assertEquals(prodPage.getFirstProductName(), obj[i][0].toString());
        }

        softAssert.assertAll();
        /*prodPage.sortBy();
        Thread.sleep(1000);
        Assert.assertEquals(prodPage.getFirstProductPrice(), "$29.99");
        Assert.assertEquals(prodPage.getFirstProductName(), "Sauce Labs Backpack");*/
    }
}
