package pageobjects.common.ios;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
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
            locator.sendKeysToKeyBoard(k);
        }
    }

    public void callAlertAction(boolean selection){
        if(selection) {
            locator.switchToFrame("alert.Accept");
        }else{
            locator.switchToFrame("alert.Dismiss");
        }
    }
}
