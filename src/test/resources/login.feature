
  Feature: The scenarios listed are regarding the Login (user name and password)

    Scenario: update-password
      Given User is able to login successfully
      When User attempts to change password
      Then Password is updated successfully
      And User is able to login with the new password