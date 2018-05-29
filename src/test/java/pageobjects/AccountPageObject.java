package pageobjects;

import utils.AndroidLocator;
import config.DriverCreator;
import utils.IOSLocator;


public class AccountPageObject {
    DriverCreator locator=null;
    String osType=System.getProperty("MobilePlatform");
    AccountPageObject(){
        switch(osType){
            case "android":
                locator= new AndroidLocator();
                break;
            case "ios":
                locator=new IOSLocator();
                break;
        }
    }
}
