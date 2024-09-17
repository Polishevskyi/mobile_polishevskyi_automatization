package driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.SkipException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AppFactory {
    static AppiumDriver driver;
    static HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

    private static HashMap<String, Object> getBrowserstackOptions() {
        browserstackOptions.put("userName", "serhiitestovkiy_fyRQuV");
        browserstackOptions.put("accessKey", "UUpKxrixq9XqPp7mhzqe");
        browserstackOptions.put("appiumVersion", "2.4.1");
        return browserstackOptions;
    }

    private static void android_launchApp() throws MalformedURLException {
        browserstackOptions = getBrowserstackOptions();

        UiAutomator2Options options = new UiAutomator2Options();

        if (AppData.isCloud.contains("false")) {
            options.setDeviceName("Pixel 6 Pro API 34")
                    .setPlatformVersion("14.0")
                    .setAppPackage("com.saucelabs.mydemoapp.rn")
                    .setAppActivity(".MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } else {
            options.setDeviceName("Google Pixel 6 Pro")
                    .setPlatformVersion("13.0")
                    .setAppPackage("com.saucelabs.mydemoapp.rn")
                    .setAppActivity(".MainActivity")
                    .setApp("bs://d47dee8664b8ec67348d554b8dde75c28d870d50")
                    .setCapability("bstack:options", browserstackOptions);
            driver = new AndroidDriver(new URL("http://hub-cloud.browserstack.com/wd/hub/"), options);
        }

        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

    private static void ios_launchApp() throws MalformedURLException {
        browserstackOptions = getBrowserstackOptions();

        XCUITestOptions options = new XCUITestOptions();

        if (AppData.isCloud.contains("false")) {
            options.setDeviceName("iPhone 15 Pro")
                    .setPlatformVersion("17.2")
                    .setBundleId("com.saucelabs.mydemoapp.rn");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        } else {
            options.setDeviceName("iPhone 15 Pro")
                    .setPlatformVersion("17.2")
                    .setBundleId("com.saucelabs.mydemoapp.rn")
                    .setApp("bs://24b0d4c64ff227ceb4bad47b8c2018c3d893947a")
                    .setCapability("bstack:options", browserstackOptions);
            driver = new IOSDriver(new URL("http://hub-cloud.browserstack.com/wd/hub/"), options);
        }

        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    }

    public static void launchApp() throws MalformedURLException {
        System.out.println("entering into launchapp");
        if (AppData.platform.contains("ios")) {
            AppFactory.ios_launchApp();
        } else if (AppData.platform.contains("android")) {
            AppFactory.android_launchApp();
            System.out.println("Android launched...");
        } else
            throw new SkipException("Enter valid platform value, android/ios");
    }
}
