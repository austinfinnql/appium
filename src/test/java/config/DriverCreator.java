package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.json.simple.JSONObject;
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
    public void quit(){
        if(this.androidDriver!=null) {
            this.androidDriver.quit();
        }else{
            this.iosDriver.quit();
        }
    }

    public void setBrowserStackAndroid(String username, String accessKey, AndroidDriver androidDriver, JSONObject config,DesiredCapabilities dc ) throws MalformedURLException{
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), dc);
    }

    public void setBrowserStackIOS(String username, String accessKey, IOSDriver iosDriver, JSONObject config,DesiredCapabilities dc ) throws MalformedURLException{
        iosDriver = new IOSDriver<AndroidElement>(new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), dc);
    }
}
