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

public class SettingsPageObject {

    LocatorInterface locator=null;
    Collection<Node> dataModel=null;
    JsonUtils jsonUtils=null;

    public SettingsPageObject(){
            jsonUtils= new JsonUtils();
            if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
                locator=new AndroidLocator();
                dataModel=jsonUtils.getDataModel("login/android/SettingsOptions.json");
            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("login/ios/SettingsOptions.json");
            }

    }

    public void tapOnSettingsOption(){
        Node node=jsonUtils.getValues(dataModel,"options");
        List<MobileElement> mobileElementList=locator.getLocators(node.getType(),node.getIdentifier());
        MobileElement mobileElement=null;

        Iterator<MobileElement> itr= mobileElementList.iterator();
        while(itr.hasNext()){
            mobileElement=itr.next();
            if(mobileElement.getText().toLowerCase().contains("settings")){
                mobileElement.click();
                break;
            }
        }
    }

    public void tapOnLogoutOption(){
        Node node=jsonUtils.getValues(dataModel,"options");
        List<MobileElement> mobileElementList=locator.getLocators(node.getType(),node.getIdentifier());
        MobileElement mobileElement=null;

        Iterator<MobileElement> itr= mobileElementList.iterator();
        while(itr.hasNext()){
            mobileElement=itr.next();
            if(mobileElement.getText().toLowerCase().contains("logout")){
                mobileElement.click();
                break;
            }
        }
    }
}
