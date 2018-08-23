package pageobjects.common.android;

import config.locators.AndroidLocator;


import pageobjects.common.CommonFactory;
import utils.JsonUtils;
import utils.DataModel;
import utils.Node;

import java.io.FileNotFoundException;
import java.security.Key;
import java.util.Collection;

public class AndroidActions extends CommonFactory {

    AndroidLocator locator=null;
    Collection<Node> dataModel=null;
    JsonUtils jsonUtils=null;

    public AndroidActions(){
        locator=new AndroidLocator();
        jsonUtils= new JsonUtils();
        dataModel=jsonUtils.getDataModel("common/android/Common.json");
    }

    public void useDigitsOnKeyboard(int[] key){
        for (int k:key) {
            locator.sendKeysToKeyBoard(k);
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
