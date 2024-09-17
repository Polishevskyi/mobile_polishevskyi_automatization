package base;

public class AppData {
    public static String platform = System.getProperty("platform", "ios");
    public static String useGesturePlugin = System.getProperty("useGesturePlugin", "true");
    public static String chromeAutoDownloadDriver = System.getProperty("chromeAutoDownloadDriver", "true");
    public static String isCloud = System.getProperty("isCloud", "true");
}

/*
Platform:
android
ios

Property:
true
false
*/