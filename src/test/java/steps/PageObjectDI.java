package steps;

import pageobjects.common.CommonFactory;
import pageobjects.home.HomePageObject;
import pageobjects.login.LoginPageObject;
import pageobjects.onBoarding.OnBoardingPageObject;
import pageobjects.settings.AppSettingsPageObject;
import pageobjects.settings.SettingsPageObject;

public class PageObjectDI {
    public static LoginPageObject loginPageObject=null;
    public static HomePageObject homePageObject=null;
    public static SettingsPageObject settingsPageObject=null;
    public static AppSettingsPageObject appSettingsPageObject=null;;
    public static CommonFactory commonFactory=null;;
    public static OnBoardingPageObject onBoardingPageObject=null;

    public PageObjectDI(){
        if(loginPageObject==null){
            loginPageObject=new LoginPageObject();
            homePageObject=new HomePageObject();
            settingsPageObject=new SettingsPageObject();
            appSettingsPageObject=new AppSettingsPageObject();;
            commonFactory=new CommonFactory();;
            onBoardingPageObject=new OnBoardingPageObject();
        }
    }
}
