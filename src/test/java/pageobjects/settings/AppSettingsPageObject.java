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
                dataModel=jsonUtils.getDataModel("login/android/SettingsOptions.json");
            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("login/ios/SettingsOptions.json");
            }

    }

    public void tapChangePasscodeOption(){
        Node node=jsonUtils.getValues(dataModel,"changepassCode");
        MobileElement mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();
    }

    public boolean verifyPassCodeChange(){
        Node node=jsonUtils.getValues(dataModel,"passcodechanged");
        return locator.getLocator(node.getType(),node.getIdentifier()).isDisplayed();
    }

    public void navigateBackToSettings(){
        Node node=jsonUtils.getValues(dataModel,"navigateback");
        locator.getLocator(node.getType(),node.getIdentifier()).click();
    }
}
