package utils;

import config.DriverCreator;
import io.appium.java_client.AppiumDriver;

public class IOSLocator {
    public static AppiumDriver driver = null;
    IOSLocator(){
        driver=DriverCreator.GetDriver();
    }

}
