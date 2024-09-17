package tests;

import base.BaseTest;
import driver.AppDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

import static base.StringHelper.*;

public class LoginTest extends BaseTest {

    MenuPage menuPage;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void setup() {
        menuPage = new MenuPage();
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        menuPage.navigateToLogin();
    }

    @Test(priority = 4)
    public void validLoginTest() {
        loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        Assert.assertTrue(productsPage.waitForProductText());
    }

    @Test(priority = 1)
    public void invalidLogin_emptyUserNameTest() {
        loginPage.login("", VALID_PASSWORD);
        Assert.assertEquals(loginPage.getUserNameErrorText(), ERROR_USERNAME_REQUIRED);
    }

    @Test(priority = 2)
    public void invalidLogin_emptyPasswordTest() {
        loginPage.login(VALID_USERNAME, "");
        Assert.assertEquals(loginPage.getPasswordErrorText(), ERROR_PASSWORD_REQUIRED);
    }

    @Test(dataProvider = "invalid-login-dataProvider", priority = 3)
    public void invalidLogin_Test(String uName, String password, String errorText) {
        loginPage.login(uName, password);
        Assert.assertEquals(loginPage.getCredentialsErrorText(), errorText);
    }

    @DataProvider(name = "invalid-login-dataProvider")
    public Object[][] dataProviderArr() {
        Object[][] objects = {
                {VALID_USERNAME, "1234", ERROR_INVALID_CREDENTIALS},
                {"bob@example", "1234", ERROR_INVALID_CREDENTIALS}
        };
        return objects;
    }
}
