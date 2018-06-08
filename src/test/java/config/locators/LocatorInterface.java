package config.locators;

import io.appium.java_client.MobileElement;

import java.util.List;

public interface LocatorInterface {
    public MobileElement getLocator(final String strategy, final String element);
    public List getLocators(final String strategy, final String element);
    public void switchToStub();

}
