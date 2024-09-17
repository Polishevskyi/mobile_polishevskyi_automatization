package base;

public class AppData {
    public static String platform = System.getProperty("platform", "ios");
    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "true");
    public static String isCloud = System.getProperty("isCloud", "true");
}

//mvn clean test -Dplatform=android
//mvn test -Dplatform="android" -DuseGesturePlugin="false" -DchromeAutoDownloadDriver="false" -DisCloud="false"

//appium server -a 127.0.0.1 -pa /wd/hub --allow-cors - for Appium Inspector
//appium - for run tests

// Must run emulator before tests
//{
//  "appium:automationName": "UiAutomator2",
//  "platformName": "android",
//  "appium:platformVerion": "13.0",
//  "appium:appPackage": "com.saucelabs.mydemoapp.rn",
//  "appium:deviceName": "Pixel 6 Pro API 34",
//  "appium:appActivity": ".MainActivity"
//}

// Don't need to run simulator before tests
//{
//  "appium:automationName": "XCUITest",
//  "platformName": "iOS",
//  "appium:platformVerion": "17.2",
//  "appium:bundleID": "com.saucelabs.mydemoapp.rn",
//  "appium:deviceName": "iPhone 15 Pro"
//}

// BS iOS
//{
//        "appium:automationName": "XCUITest",
//        "platformName": "iOS",
//        "appium:platformVerion": "17.2",
//        "appium:bundleID": "com.saucelabs.mydemoapp.rn",
//        "appium:deviceName": "iPhone 15 Pro",
//        "appium:app": "bs://24b0d4c64ff227ceb4bad47b8c2018c3d893947a"
//        }

// BS Android
//{
//        "appium:automationName": "UiAutomator2",
//        "platformName": "android",
//        "appium:platformVerion": "13.0",
//        "appium:appPackage": "com.saucelabs.mydemoapp.rn",
//        "appium:deviceName": "Google Pixel 6 Pro",
//        "appium:appActivity": ".MainActivity",
//        "appium": "bs://d47dee8664b8ec67348d554b8dde75c28d870d50"
//        }