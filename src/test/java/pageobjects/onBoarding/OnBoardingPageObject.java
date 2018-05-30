package pageobjects.onBoarding;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import cucumber.runtime.java.StepDefAnnotation;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.io.FileNotFoundException;

public class OnBoardingPageObject {

    LocatorInterface locator=null;
    DataModel dataModel=null;
    JsonUtils jsonUtils=null;

    OnBoardingPageObject(){
        try {
            if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
                locator=new AndroidLocator();
                dataModel=jsonUtils.getDataModel("onBoarding/android/OnBoarding.json");
            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("onBoarding/ios/OnBoarding.json");
            }
            jsonUtils= new JsonUtils();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void tapOnLoginOnHome(){
        Node node=jsonUtils.getValues(dataModel,"loginBtn");
        locator.getLocator(node.getType(),node.getIdentifier()).click();
    }

}
