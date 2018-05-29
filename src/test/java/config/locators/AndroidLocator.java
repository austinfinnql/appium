package config.locators;

import config.DriverCreator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class AndroidLocator  {

    public static AppiumDriver driver = null;
    AndroidLocator(){
        driver=DriverCreator.getDriver();
    }

    public AndroidElement getLocator(final String strategy, final String element){
        this.driver=DriverCreator.getDriver();

        Wait wait= new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(15,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        //final MobileBy mobileBy=new MobileBy.ByAndroidUIAutomator(element);

        AndroidElement e=null;
        switch (strategy) {
            case ("id"):
                e = initDriver(this.driver, new MobileBy.ByAndroidUIAutomator
                        ("new UiSelector().resourceId(\"au.com.qantas.qantas:id/" + element + "\")"));
                break;
        }


        return e;
    }

    private AndroidElement initDriver(AppiumDriver driver, MobileBy.ByAndroidUIAutomator byAndroidUIAutomator) {
    }

    public AndroidElement initDriverBy(AndroidDriver driver, MobileBy byType){
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
    }

}
