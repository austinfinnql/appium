package pageobjects.home;

import config.AppiumController;
import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.io.FileNotFoundException;
import java.util.Collection;

public class HomePageObject {

    LocatorInterface locator=null;
    Collection<Node> dataModel=null;
    JsonUtils jsonUtils=null;

    public HomePageObject(){

            jsonUtils= new JsonUtils();
            if(AppiumController.PLATFORM.equals("android")){
                locator=new AndroidLocator();
                dataModel=jsonUtils.getDataModel("home/android/Home.json");
            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("home/ios/Home.json");
            }
    }

    public void tapOnMoreButton(){
        Node node=jsonUtils.getValues(dataModel,"more");
        locator.getLocator(node.getType(),node.getIdentifier()).click();
    }
    public String validateGreetingsOnHome(){
        Node node=jsonUtils.getValues(dataModel,"greeting");
        return locator.getLocator(node.getType(),node.getIdentifier()).getText();
    }
    public String validatePointsLabelOnHome(){
        Node node=jsonUtils.getValues(dataModel,"pointslabel");
        return locator.getLocator(node.getType(),node.getIdentifier()).getText();
    }
}
