package pageobjects.common;

import config.AppiumController;
import io.appium.java_client.MobileElement;
import pageobjects.common.android.AndroidActions;
import pageobjects.common.ios.IOSActions;

public class CommonFactory {

    public  void callAlertAction(boolean selection){
        if(AppiumController.PLATFORM.equals("android")){
            new AndroidActions().callAlertAction(selection);
        }else{
           new IOSActions().callAlertAction(selection);
        }
    }

    public void useDigitsOnKeyboard(int[] key){
        if(AppiumController.PLATFORM.equals("android")){
            new AndroidActions().useDigitsOnKeyboard(key);
        }else{
             new IOSActions().useDigitsOnKeyboard(key);
        }
    }

    public void useTouchActions(MobileElement key){
        new IOSActions().useTouchActions(key);
    }
}
