package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

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
        loginPage.login("bob@example.com", "10203040");
        Assert.assertTrue(productsPage.waitForProductText());
    }

    @Test(priority = 1)
    public void invalidLogin_emptyUserNameTest() {
        loginPage.login("", "10203040");
        Assert.assertEquals(loginPage.getUserNameErrorText(), "Username is required");
    }

    @Test(priority = 2)
    public void invalidLogin_emptyPasswordTest() {
        loginPage.login("bob@example.com", "");
        Assert.assertEquals(loginPage.getPasswordErrorText(), "Password is required");
    }

    @Test(dataProvider = "invalid-login-dataProvider", priority = 3)
    public void invalidLogin_Test(String uName, String password, String errorText) {
        loginPage.login(uName, password);
        Assert.assertEquals(loginPage.getCredentialsErrorText(), errorText);
    }

    @DataProvider(name = "invalid-login-dataProvider")
    public Object[][] dataProviderArr() {
        Object[][] objects = {
                {"bob@example.com", "1234", "Provided credentials do not match any user in this service."},
                {"bob@example", "1234", "Provided credentials do not match any user in this service."}
        };
        return objects;
    }
}
