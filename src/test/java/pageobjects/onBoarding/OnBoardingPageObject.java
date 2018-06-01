package pageobjects.onBoarding;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import cucumber.runtime.java.StepDefAnnotation;
import steps.PageObjectDI;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.io.FileNotFoundException;
import java.util.Collection;

public class OnBoardingPageObject {

    LocatorInterface locator=null;
    static Collection<Node> dataModel=null;
    JsonUtils jsonUtils=null;

    public OnBoardingPageObject(){

            jsonUtils= new JsonUtils();
            if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
                locator=new AndroidLocator();
                dataModel=jsonUtils.getDataModel("onBoarding/android/OnBoarding.json");
                System.out.println("debug");
            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("onBoarding/ios/OnBoarding.json");
            }

    }
    public void tapOnLoginOnBoarding(){
        Node node=jsonUtils.getValues(dataModel,"loginBtn");
        locator.getLocator(node.getType(),node.getIdentifier()).click();
    }

}
