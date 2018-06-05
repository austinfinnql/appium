package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
public class DriverCreator  {

    public static AndroidDriver<AndroidElement> androidDriver=null;
    public static IOSDriver<IOSElement> iosDriver=null;

    public void setAndroidDriver(DesiredCapabilities dc) throws MalformedURLException {
        androidDriver=new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),dc);
    }

    public void setIOSDriver(DesiredCapabilities dc)throws MalformedURLException{
        iosDriver=new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"),dc);
    }
}
