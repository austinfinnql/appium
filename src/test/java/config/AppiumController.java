package config;

import cucumber.api.java.Before;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;

public class AppiumController {

    public static String PLATFORM="android";

    @Before
    public static void setup() throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        PLATFORM=System.getProperty("MobilePlatform").toLowerCase();

        switch(PLATFORM) {
            case "android":
                new DriverCreator().setAndroidDriver(getCapabilities(dc));
                break;
            case "ios":
                new DriverCreator().setIOSDriver(getCapabilities(dc));
                break;
            default:
                throw new IllegalArgumentException("Please set 'ios' or 'android' as OS Type");
        }
    }


    public static DesiredCapabilities getCapabilities(DesiredCapabilities dc){
        switch(PLATFORM){
            case "android":
                dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                break;
            case "ios":
                String DeviceUdid = "3FDCD44E-F7CF-4CE2-88AD-CEED4A1043E0";

                //IOS Capabilties for real device and simulator
                dc.setCapability("platformName", "iOS");
                dc.setCapability("deviceName", "iPhone 6 ");
                dc.setCapability("bundleId", "com.qantas.fs.dev");
                dc.setCapability("noReset", true);
                dc.setCapability("automationName", "XCUITest");
                dc.setCapability(MobileCapabilityType.UDID, DeviceUdid);
                break;
            default:

                throw new IllegalArgumentException("Please set 'ios' or 'android' as OS Type");

        }
        return dc;
    }


   /* public void browerStackConfig(){
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("key");
        }

        String app = System.getenv("BROWSERSTACK_APP_ID");
        if(app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }

        if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
            l = new Local();
            Map<String, String> options = new HashMap<String, String>();
            options.put("key", accessKey);
            l.start(options);
        }

        driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
    }*/
}
