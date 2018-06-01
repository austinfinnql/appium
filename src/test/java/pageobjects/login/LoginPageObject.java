package pageobjects.login;

import config.DriverCreator;
import config.locators.AndroidLocator;
import config.locators.IOSLocator;
import config.locators.LocatorInterface;
import io.appium.java_client.MobileElement;
import pageobjects.common.Android.AndroidActions;
import utils.DataModel;
import utils.JsonUtils;
import utils.Node;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import java.io.FileNotFoundException;


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
        mobileElement.click();
        mobileElement.sendKeys("2524");

        //enter submit
        node=jsonUtils.getValues(dataModel,"loginbtn");
        mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();

        //enter sms code using keyboard
        AndroidActions actions=new AndroidActions();

        //AndroidKey[] arr=new AndroidKey[6];
        int[] arr=new int[6];
        int count=0;
        while(count<6){arr[count]=1;count++;}
        actions.useDigitsOnKeyboard(arr);



        //Accept TAC
        node=jsonUtils.getValues(dataModel,"TAC");
        mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();

        //Set the pin for the app
        int[] pinArr={1,4,5,6};
        setPin(pinArr);

        //selecting no to fingerprint
        node=jsonUtils.getValues(dataModel,"fingerprintno");
        mobileElement=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement.click();

/*        node=jsonUtils.getValues(dataModel,"num1");
        MobileElement mobileElement1=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement1.click();

        node=jsonUtils.getValues(dataModel,"num4");
        MobileElement mobileElement4=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement4.click();

        node=jsonUtils.getValues(dataModel,"num5");
        MobileElement mobileElement5=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement5.click();

        node=jsonUtils.getValues(dataModel,"num9");
        MobileElement mobileElement9=locator.getLocator(node.getType(),node.getIdentifier());
        mobileElement9.click();*/
    }
    //
    //public void setPin(AndroidKey[] pinArrary){
    public void setPin(int[] pinArrary){
        new AndroidActions().useDigitsOnKeyboard(pinArrary);
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        new AndroidActions().useDigitsOnKeyboard(pinArrary);
    }
}
