package base;

import driver.AppFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeClass
    public static void launchApp() throws MalformedURLException {
        AppFactory.launchApp();
    }

    @AfterMethod
    public static void closeApp(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Util.getScreenshot(result.getTestName());
        }
    }

    @BeforeSuite
    public static void serverStart() {
        if (AppData.isCloud.contains("false")) {
            base.AppiumServer.start();
        }
    }

    @AfterSuite
    public static void serverStop() {
        base.AppiumServer.stop();
    }
}
