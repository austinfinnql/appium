import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumController {

    public static IOSDriver iOSDriver;

    @BeforeTest
    public static void setup() throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();

        String DeviceUdid = "3FDCD44E-F7CF-4CE2-88AD-CEED4A1043E0";

        //Capabilties for real device and simulator
        dc.setCapability("platformName", "iOS");
        dc.setCapability("deviceName", "iPhone 6 ");
        dc.setCapability("bundleId", "com.qantas.fs.dev");
        dc.setCapability("noReset", true);
        dc.setCapability("automationName", "XCUITest");
        dc.setCapability(MobileCapabilityType.UDID, DeviceUdid);

        iOSDriver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }
}
