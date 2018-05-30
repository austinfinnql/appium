package pageobjects.common.Android;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import io.appium.java_client.android.nativekey.AndroidKey;
import pageobjects.common.CommonFactory;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.io.FileNotFoundException;

public class AndroidActions extends CommonFactory {

    AndroidLocator locator=null;
    DataModel dataModel=null;
    JsonUtils jsonUtils=null;

    public AndroidActions(){
        try {
            locator=new AndroidLocator();
            dataModel=jsonUtils.getDataModel("login/android/Common.json");
            jsonUtils= new JsonUtils();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void useDigitsOnKeyboard(AndroidKey[] key){
        for(int itr=0;itr<key.length;itr++) {
            locator.sendKeysWithKeyBoard(key[itr]);
        }
    }

    public void callAlertAction(boolean selection){
        if(selection){
            Node node=jsonUtils.getValues(dataModel,"yesonalert");
            locator.getLocator(node.getType(),node.getIdentifier()).click();
        }else{
            Node node=jsonUtils.getValues(dataModel,"noonalert");
            locator.getLocator(node.getType(),node.getIdentifier()).click();
        }
    }
}
