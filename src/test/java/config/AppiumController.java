package config;

import com.browserstack.local.Local;
import cucumber.api.java.*;
import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AppiumController {

    public static String PLATFORM="android";
    Local l;
    //DesiredCapabilities dc;

    @Before
    public static void setup() throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();
        PLATFORM=System.getProperty("MobilePlatform").toLowerCase();

//        String userBrowserstack=System.getProperty("USE-BROWSERSTACK");
//        if(userBrowserstack.equals("false")) {
            switch (PLATFORM) {
                case "android":
                    new DriverCreator().setAndroidDriver(getCapabilities(dc));
                    break;
                case "ios":
                    new DriverCreator().setIOSDriver(getCapabilities(dc));
                    break;
                default:
                    throw new IllegalArgumentException("Please set 'ios' or 'android' as OS Type");
            }
//        }else{
//
//
//            //browerStackConfig(PLATFORM);
//        }
    }

    public static DesiredCapabilities getCapabilities(DesiredCapabilities dc){
        switch(PLATFORM){
            case "android":
                dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                break;
            case "ios":

                dc.setCapability("noReset", true);
                dc.setCapability("useNewWDA", true);
                break;
            default:

                throw new IllegalArgumentException("Please set 'ios' or 'android' as OS Type");

        }
        return dc;
    }


//    public void browerStackConfig(String platform)   {
//
//        JSONParser parser = new JSONParser();
//        JSONObject config =null;
//        try {
//            config = (JSONObject) parser.parse(new FileReader("src/test/config/config.json"));
//        }catch (IOException | ParseException e){
//            e.printStackTrace();
//        }
//        JSONObject envs = (JSONObject) config.get("environments");
//
//         dc = new DesiredCapabilities();
//
//        Map<String, String> envCapabilities = (Map<String, String>) envs.get("environment");
//        Iterator it = envCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            dc.setCapability(pair.getKey().toString(), pair.getValue().toString());
//        }
//
//        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
//        it = commonCapabilities.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            if(dc.getCapability(pair.getKey().toString()) == null){
//                dc.setCapability(pair.getKey().toString(), pair.getValue().toString());
//            }
//        }
//
//        String username = System.getenv("BROWSERSTACK_USERNAME");
//        if(username == null) {
//            username = (String) config.get("user");
//        }
//
//        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
//        if(accessKey == null) {
//            accessKey = (String) config.get("key");
//        }
//
//        String app = System.getenv("BROWSERSTACK_APP_ID");
//        if(app != null && !app.isEmpty()) {
//            dc.setCapability("app", app);
//        }
//
//        if(dc.getCapability("browserstack.local") != null && dc.getCapability("browserstack.local") == "true"){
//            l = new Local();
//            Map<String, String> options = new HashMap<String, String>();
//            options.put("key", accessKey);
//            try {
//                l.start(options);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        if(platform.equals("android")) {
//            new DriverCreator().setBrowserStackAndroid( username,  accessKey,config);
//        }else{
//            new DriverCreator().setBrowserStackIOS( username,  accessKey, config);
//        }
//    }

    @After
    public void tearDown() throws Exception {
        new DriverCreator().quit();
        if(l != null) l.stop();
    }
}
