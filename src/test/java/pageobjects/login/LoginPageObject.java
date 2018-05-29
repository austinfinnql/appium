package pageobjects.login;

import config.DriverCreator;
import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import utils.DataModel;
import utils.JsonUtils;

import java.io.FileNotFoundException;


public class LoginPageObject {
    LocatorInterface locator=null;
    DataModel dataModel=null;
    JsonUtils jsonUtils=null;

    LoginPageObject(){
        if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
            locator=new AndroidLocator();
        }else{
            locator=new IOSLocator();
        }
        jsonUtils= new JsonUtils();
        try {
            dataModel=jsonUtils.getDataModel("login/Login.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void tapOnLoginOnHome(){
        jsonUtils.getValues(dataModel,"loginBtn");
    }
}
