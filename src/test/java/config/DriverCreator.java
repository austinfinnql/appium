package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class DriverCreator  {

    public static AppiumDriver driver=null;
    public static Wait wait=null;

    public void setAndroidDriver(DesiredCapabilities dc){
        driver=new AndroidDriver(dc);
    }
    public void setIOSDriver(DesiredCapabilities dc){
        driver=new IOSDriver(dc);
    }

    public static AppiumDriver getDriver(){
        wait = new FluentWait(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return driver;
    }
}
