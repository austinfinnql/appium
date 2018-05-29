package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverCreator  {

    public static AppiumDriver driver=null;

    public void setAndroidDriver(DesiredCapabilities dc){
        driver=new AndroidDriver(dc);
    }
    public void setIOSDriver(DesiredCapabilities dc){
        driver=new IOSDriver(dc);
    }

    public static AppiumDriver<AndroidElement> GetDriver(){
        return driver;
    }
}
