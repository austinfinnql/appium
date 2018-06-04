package pageobjects.common;

import pageobjects.common.Android.AndroidActions;

public class CommonFactory {

    public  void callAlertAction(boolean selection){
        if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
            new AndroidActions().callAlertAction(selection);
        }else{
           // new IOSActions().callAlertAction(selection);
        }
    }

    public void useDigitsOnKeyboard(int[] key){
        if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
            new AndroidActions().useDigitsOnKeyboard(key);
        }else{
            // new IOSActions().callAlertAction(selection);
        }
    }
}
