package steps;

import cucumber.api.java.en.Given;
import pageobjects.login.LoginPageObject;
import pageobjects.onBoarding.OnBoardingPageObject;

public class OnBoardingSteps {

    public OnBoardingPageObject onBoardingPageObject = null;
    public LoginPageObject loginPageObject = null;
    @Given("^User is able to login successfully from OnBoarding$")
    public void userIsAbleToLoginsuccessfullyFromOnBoarding(){
        //tap the login button
        onBoardingPageObject.tapOnLoginOnHome();
        loginPageObject.performLogin();
    }
}
