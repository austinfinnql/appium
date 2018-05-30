
  Feature: The scenarios listed are regarding the Login (user name and password)
    @LoginTests
    Scenario: update-passcode
      Given User is able to login successfully from OnBoarding
      When User attempts to change passcode
      Then Passcode is updated successfully
      And User is able to login with the new passcode