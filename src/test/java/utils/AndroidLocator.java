package utils;

import config.DriverCreator;
import io.appium.java_client.AppiumDriver;

public class AndroidLocator  {

    public static AppiumDriver driver = null;
    AndroidLocator(){
        driver=DriverCreator.getDriver();
    }
}
