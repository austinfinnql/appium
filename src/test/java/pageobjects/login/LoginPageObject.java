package pageobjects.login;

import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import pageobjects.common.CommonFactory;
import utils.JsonUtils;
import utils.Node;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class LoginPageObject {

    LocatorInterface locator=null;
    Collection<Node> dataModel=null;
    JsonUtils jsonUtils=null;

    public LoginPageObject(){
            jsonUtils= new JsonUtils();
            if(System.getProperty("MobilePlatform").toLowerCase().equals("android")){
                locator=new AndroidLocator();
                dataModel=jsonUtils.getDataModel("login/android/Login.json");

            }else{
                locator=new IOSLocator();
                dataModel=jsonUtils.getDataModel("login/ios/Login.json");
            }
    }

    public void performLogin(){
        //enter member number
        Node node=jsonUtils.getValues(dataModel,"membernumber");
        MobileElement mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();

        //since we will hard code the pin values, we want to make sure
        // the Member number is random so there is no issues with duplication of the pin
        int randomNum = ThreadLocalRandom.current().nextInt(101, 5000 + 1);
        mobileElement.sendKeys( String.valueOf(randomNum));

        // enter lastName
        node=jsonUtils.getValues(dataModel,"lastname");
        mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();
        mobileElement.sendKeys("user");

        // enter lastName
        node=jsonUtils.getValues(dataModel,"pin");
        mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        //mobileElement.click();
        mobileElement.sendKeys("2524");

        //enter submit
        node=jsonUtils.getValues(dataModel,"loginbtn");
        mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();

        //enter sms code using keyboard
      enterSMSCode();

        //Accept TAC
        node=jsonUtils.getValues(dataModel,"TAC");
        mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();

        //Set the pin for the app
        String[] pinArr={"num1", "num4", "num5", "num6"};
        setPin(pinArr);

        // Fingerprint is not shown in stub build and so disabled for now
        //selecting no to fingerprint
       // node=jsonUtils.getValues(dataModel,"fingerprintno");
       // mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
       // mobileElement.click();

    }

    //To set the pin
    public void loginUsingPin(String[] pinArray){
        Node node=null;
        MobileElement mobileElement=null;
        //the keyboard for setting pin does not get detected with  AndroidKeyCode
        //we have to use the accessibility for this screen.
        for(String k:  pinArray){
            node=jsonUtils.getValues(dataModel,k);
            locator.getLocator(node.getType(),node.getIdentifier()).click();
        }

    }
    //To set the pin
    public void setPin(String[] pinArray){
        loginUsingPin(pinArray);
        loginUsingPin(pinArray);
    }

    // To enter the SMS pin, by default all 1's are enetered.
    private void enterSMSCode(){
        int[] arr=new int[6];
        int count=0;
        while(count<6){arr[count]=AndroidKeyCode.KEYCODE_1;count++;}
        new CommonFactory().useDigitsOnKeyboard(arr);
    }
}
