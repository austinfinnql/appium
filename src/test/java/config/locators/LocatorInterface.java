package config.locators;

import io.appium.java_client.MobileElement;

public interface LocatorInterface {
    public MobileElement getLocator(final String strategy, final String element);

}
