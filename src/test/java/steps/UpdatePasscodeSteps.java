package steps;


import cucumber.api.java.en.*;
import org.testng.Assert;

public class UpdatePasscodeSteps extends PageObjectDI{

    @When("^User attempts to change passcode$")
    public void userAttemptsToChangePasscode() throws Throwable {

        // tap on more button
        PageObjectDI.homePageObject.tapOnMoreButton();
        //select settings
        PageObjectDI.settingsPageObject.tapOnSettingsOption();
        //select "change passcode"
        PageObjectDI.appSettingsPageObject.tapChangePasscodeOption();

        //change passcode

/*        AndroidKey[] pinArr={AndroidKey.DIGIT_6,
                AndroidKey.DIGIT_5,
                AndroidKey.DIGIT_4,
                AndroidKey.DIGIT_5};*/
        int[] pinArr={6,5,4,5};
        PageObjectDI.loginPageObject.setPin(pinArr);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^Passcode is updated successfully$")
    public void passcodeIsUpdatedSuccessfully() throws Throwable {
        Assert.assertTrue(PageObjectDI.appSettingsPageObject.verifyPassCodeChange());
    }

    @And("^User is able to login with the new passcode$")
    public void userIsAbleToLoginWithTheNewPasscode() throws Throwable {
        //tap on more button
        PageObjectDI.appSettingsPageObject.navigateBackToSettings();

        //tap on logout
        PageObjectDI.settingsPageObject.tapOnLogoutOption();

        //tap "yes" on alert
        PageObjectDI.commonFactory.callAlertAction(true);

        //tap in the new passcode
        int[] pinArr={1,2,5,6};
        PageObjectDI.loginPageObject.setPin(pinArr);

        //validate user is on the home view
        Assert.assertTrue(PageObjectDI.homePageObject.validateOnHome());
    }
}
