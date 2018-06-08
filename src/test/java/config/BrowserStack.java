import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;


/*
Example configuration: use only as reference
 */
public class BrowserStack {

    public static String userName = "yasaswilakkaraju1";
    public static String accessKey = "QGhvxCxTXmh1VVo1fFbQ";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy Note 8");
        caps.setCapability("os_version", "7.1");
        caps.setCapability("app", "bs://592a25102fc1ca34f637a693d9275e52d987f580");


        AndroidDriver driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        driver.quit();
    }
}