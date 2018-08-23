package pageobjects.common.ios;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import io.appium.java_client.MobileElement;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.util.Collection;

public class IOSActions {

    IOSLocator locator=null;
    JsonUtils jsonUtils=null;
    Collection<Node> dataModel=null;
    public IOSActions(){
        locator=new IOSLocator();
        jsonUtils= new JsonUtils();
        dataModel=jsonUtils.getDataModel("common/ios/Common.json");
    }

    public void useDigitsOnKeyboard(int[] key){
        for (int k:key) {
            locator.sendKeysToKeyBoard(String.valueOf(k));
        }
    }

    public void useTouchActions(MobileElement key){
            locator.sendKeysToKeyBoard(key);
    }

    public void callAlertAction(boolean selection){
        if(selection) {
            locator.switchToFrame("alert.Accept");
        }else{
            locator.switchToFrame("alert.Dismiss");
        }
    }
}
