package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    By productPage = AppiumBy.accessibilityId("container header");
    By itemNames;
    By first_itemName;
    By first_itemPrice;

    public ProductsPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            itemNames = AppiumBy.xpath("//android.widget.TextView[@content-desc='store item text']");
            first_itemName = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item text'])[1]");
            first_itemPrice = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item price'])[1]");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            itemNames = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='store item text']");
            first_itemName = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='store item text'])[1]");
            first_itemPrice = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='store item price'])[1]");
        }
    }

    public boolean waitForProductText() {
        return waitForEl(productPage).isDisplayed();
    }
}
