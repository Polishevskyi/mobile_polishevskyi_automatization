package pages;

import base.Util;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    //    @AndroidFindBy
    By productPage = AppiumBy.accessibilityId("container header");
    By itemNames;
    By sortByOptions = AppiumBy.accessibilityId("sort button");
    private By nameAsc = AppiumBy.accessibilityId("maneAsc");
    private By nameDesc = AppiumBy.accessibilityId("nameDesc");
    private By priceAsc = AppiumBy.accessibilityId("priceAsc");
    private By priceDesc = AppiumBy.accessibilityId("priceDesc");
    private By first_itemName;
    private By first_itemPrice;

    //android.widget.TextView[@content-desc="store item text"]

    public ProductPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
//            productPage = AppiumBy.accessibilityId("container header");
            itemNames = AppiumBy.xpath("//android.widget.TextView[@content-desc='store item text']");
            first_itemName = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item text'])[1]");
            first_itemPrice = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item price'])[1]");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
//            productPage = AppiumBy.accessibilityId("container header");
            //itemNames =
        }
    }

    public boolean waitForProductText() {
        return waitForEl(productPage).isDisplayed();
    }

    public String getFirstProductName() {
        return getText(first_itemName);
    }

    public String getFirstProductPrice() {
        return getText(first_itemPrice);
    }

    public int getItemsCount() throws InterruptedException {
        int count = Util.getItems(itemNames).size();
        System.out.println(count);
        Util.scrollToTop();
        return count;
    }

    public void sortBy() {
        waitNclick(sortByOptions);
        waitNclick(nameAsc);
    }
}
