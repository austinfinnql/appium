package pageobjects.home;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.io.FileNotFoundException;

public class HomePageObject {

    LocatorInterface locator=null;
    DataModel dataModel=null;
    JsonUtils jsonUtils=null;

    HomePageObject(){
        try {

            if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
                locator=new AndroidLocator();
                dataModel=jsonUtils.getDataModel("login/android/Home.json");
            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("login/ios/Home.json");
            }
            jsonUtils= new JsonUtils();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void tapOnMoreButton(){
        Node node=jsonUtils.getValues(dataModel,"more");
        locator.getLocator(node.getType(),node.getIdentifier()).click();
    }
    public boolean validateOnHome(){
        Node node=jsonUtils.getValues(dataModel,"greeting");
        return locator.getLocator(node.getType(),node.getIdentifier()).isDisplayed();
    }
}
