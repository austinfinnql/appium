package config.locators;

import config.DriverCreator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class IOSLocator implements LocatorInterface {
    public static AppiumDriver driver = null;
    public IOSLocator(){
        driver=DriverCreator.getDriver();
    }

    @Override
    public MobileElement getLocator(String strategy, String element) {
        return null;
    }
}
