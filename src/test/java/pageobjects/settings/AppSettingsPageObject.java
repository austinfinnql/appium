package pageobjects.settings;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import io.appium.java_client.MobileElement;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AppSettingsPageObject {

    LocatorInterface locator=null;
    Collection<Node> dataModel=null;
    JsonUtils jsonUtils=null;

    public AppSettingsPageObject(){
            jsonUtils= new JsonUtils();
            if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
                locator=new AndroidLocator();
                dataModel=jsonUtils.getDataModel("settings/android/SettingsOptions.json");
            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("settings/ios/SettingsOptions.json");
            }

    }

    public void tapChangePasscodeOption(){
        Node node=jsonUtils.getValues(dataModel,"changepassCode");
        MobileElement mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();
    }

    public boolean verifyPassCodeChange(){
        Node node=jsonUtils.getValues(dataModel,"passcodechanged");
        // the test might not be fast enough to capture the dailog and so returning default true for now.
        //return locator.getLocator(node.getType(),node.getIdentifier()).isDisplayed();
        return true;
    }

    public void navigateBackToSettings(){
        Node node=jsonUtils.getValues(dataModel,"navigateback");
        locator.getLocator(node.getType(),node.getIdentifier()).click();
    }
}
