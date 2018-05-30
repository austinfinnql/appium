package config.locators;

import config.DriverCreator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.List;

public class AndroidLocator  implements LocatorInterface{

    public static AndroidDriver<AndroidElement> driver = null;
    public AndroidLocator(){
        driver=(AndroidDriver) DriverCreator.getDriver();
    }

    @Override
    public MobileElement getLocator(final String strategy, final String element){
        AndroidElement e=null;
        switch (strategy) {
            case "id":
                e= ((AndroidElement) driver.findElement(MobileBy.AndroidUIAutomator(element)));
                break;
            case "accessibility":
                e=((AndroidElement) driver.findElement(MobileBy.AccessibilityId(element)));
            default:
                throw new IllegalArgumentException("check type of the identifier");
        }
        return e;
    }

    @Override
    public List getLocators(final String strategy, final String element){
        List<AndroidElement> e=null;
        switch (strategy) {
            case "id":
                e= (List<AndroidElement>) driver.findElements(MobileBy.AndroidUIAutomator(element));
                break;
            default:
                throw new IllegalArgumentException("check type of the identifier");
        }
        return e;
    }

    public void sendKeysWithKeyBoard(AndroidKey keyCode) {
        driver.pressKey(new KeyEvent(keyCode));
    }

    /* public AndroidElement initDriverBy(AndroidDriver driver, MobileBy byType){
       Wait wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        AndroidElement element = (AndroidElement) wait.until(new Function<AndroidDriver, AndroidElement>() {
            public AndroidElement apply(AndroidDriver driver) {
                driver= (AndroidDriver)DriverCreator.getDriver();
                return (AndroidElement) driver.findElement(byType);
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(byType));
        return element;
    }*/

}
