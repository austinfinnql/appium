package config.locators;

import config.DriverCreator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class IOSLocator implements LocatorInterface {
    public static AppiumDriver driver = null;
    public IOSLocator(){
        driver=DriverCreator.iosDriver;
    }

    @Override
    public MobileElement getLocator(String strategy, String element) {
        return null;
    }
    public List getLocators(final String strategy, final String element){return null;}
}
