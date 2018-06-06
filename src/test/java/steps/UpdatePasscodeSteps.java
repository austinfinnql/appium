package steps;


import cucumber.api.java.en.*;
import org.junit.Assert;

public class UpdatePasscodeSteps extends PageObjectDI{

    @When("^User attempts to change passcode$")
    public void userAttemptsToChangePasscode() throws Throwable {

        try{ Thread.sleep(2000);
        }catch(Exception e){ e.printStackTrace(); }
        // tap on more button
        PageObjectDI.homePageObject.tapOnMoreButton();
        //select settings
        PageObjectDI.settingsPageObject.tapOnSettingsOption();
        //select "change passcode"
        PageObjectDI.appSettingsPageObject.tapChangePasscodeOption();

        //change passcode
        String[] pinArr={"num6","num5","num4","num5"};
        PageObjectDI.loginPageObject.setPin(pinArr);
    }

    @Then("^Passcode is updated successfully$")
    public void passcodeIsUpdatedSuccessfully() throws Throwable {
        // the popup is too quick to check for and so for now its commented
        Assert.assertTrue(PageObjectDI.appSettingsPageObject.verifyPassCodeChange());
    }

    @And("^User is able to login with the new passcode$")
    public void userIsAbleToLoginWithTheNewPasscode() throws Throwable {
        //tap on more button
        PageObjectDI.appSettingsPageObject.navigateBackToSettings();

        //tap on logout
        PageObjectDI.settingsPageObject.tapOnLogoutOption();
        try { Thread.sleep(2000); }
        catch (InterruptedException e) { e.printStackTrace(); }

        //tap "yes" on alert
        PageObjectDI.commonFactory.callAlertAction(true);

        //tap in the new passcode
        String[] pinArr={"num6","num5","num4","num5"};
        PageObjectDI.loginPageObject.loginUsingPin(pinArr);

        //validate user is on the home view
        String retText=PageObjectDI.homePageObject.validateGreetingsOnHome().toLowerCase();
        Assert.assertTrue(retText.contains("good"));
        retText=PageObjectDI.homePageObject.validatePointsLabelOnHome().toLowerCase();
        Assert.assertTrue(retText.contains("points"));
    }
}
