package steps;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.testng.Assert;
import pageobjects.common.Android.AndroidActions;
import pageobjects.common.CommonFactory;
import pageobjects.home.HomePageObject;
import pageobjects.login.LoginPageObject;
import pageobjects.settings.AppSettingsPageObject;
import pageobjects.settings.SettingsPageObject;;

public class UpdatePasscodeSteps {

    @Inject private LoginPageObject loginPageObject;
    @Inject private HomePageObject homePageObject;
    @Inject private SettingsPageObject settingsPageObject;
    @Inject private AppSettingsPageObject appSettingsPageObject;
    @Inject private CommonFactory commonFactory;



    @When("^User attempts to change passcode$")
    public void userAttemptsToChangePasscode(){

        // tap on more button
        homePageObject.tapOnMoreButton();
        //select settings
        settingsPageObject.tapOnSettingsOption();
        //select "change passcode"
        appSettingsPageObject.tapChangePasscodeOption();

        //change passcode

        AndroidKey[] pinArr={AndroidKey.DIGIT_6,
                AndroidKey.DIGIT_5,
                AndroidKey.DIGIT_4,
                AndroidKey.DIGIT_5};
        loginPageObject.setPin(pinArr);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^Passcode is updated successfully$")
    public void passcodeIsUpdatedSuccessfully(){
        Assert.assertTrue(appSettingsPageObject.verifyPassCodeChange());
    }

    @And("^User is able to login with the new passcode$")
    public void UserIsAbleToLoginWithTheNewPasscode(){
        //tap on more button
        appSettingsPageObject.navigateBackToSettings();

        //tap on logout
        settingsPageObject.tapOnLogoutOption();

        //tap "yes" on alert
        commonFactory.callAlertAction(true);

        //tap in the new passcode
        AndroidKey[] pinArr={AndroidKey.DIGIT_1,
                AndroidKey.DIGIT_2,
                AndroidKey.DIGIT_5,
                AndroidKey.DIGIT_6};
        loginPageObject.setPin(pinArr);

        //validate user is on the home view
        Assert.assertTrue(homePageObject.validateOnHome());
    }
}
