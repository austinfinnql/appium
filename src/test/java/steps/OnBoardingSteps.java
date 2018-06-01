package steps;

import cucumber.api.java.en.*;
import pageobjects.login.LoginPageObject;
import pageobjects.onBoarding.OnBoardingPageObject;

public class OnBoardingSteps extends PageObjectDI{

    public OnBoardingPageObject onBoardingPageObject = null;
    public LoginPageObject loginPageObject = null;

    @Given("^User is able to login successfully from OnBoarding$")
    public void userIsAbleToLoginsuccessfullyFromOnBoarding() throws Throwable {
        //tap the login button
        PageObjectDI.onBoardingPageObject.tapOnLoginOnBoarding();
        PageObjectDI.loginPageObject.performLogin();
    }
}
