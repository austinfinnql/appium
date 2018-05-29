package config.locators;

import com.sun.javaws.exceptions.InvalidArgumentException;
import config.DriverCreator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidLocator  implements LocatorInterface{

    public static AndroidDriver driver = null;
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
            default:
                throw new IllegalArgumentException("check type of the identifier");
        }
        return e;
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
