package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {


    @When("^User attempts to change passcode$")
    public void userAttemptsToChangePassword(){

        // tap on more button

        //select settings

        //select "change passcode"

        //change passcode

    }

    @Then("^Passcode is updated successfully$")
    public void passwordIsUpdatedSuccessfully(){

        //validate user is back on App settings screen


    }

    @And("^User is able to login with the new passcode$")
    public void UserIsAbleToLoginWithTheNewPassword(){
        //tap on more button

        //tap on logout

        //tap "yes" on alert

        //tap in the new passcode

        //validate user is on the home view

    }
    @Given("^User is able to login successfully from OnBoarding$")
    public void userIsAbleToLoginsuccessfullyFromOnBoarding(){
        //tap the login button

        //enter the the login details

        //enter the sms pin

        // set passcode

        //validate user is on home view

    }
}
