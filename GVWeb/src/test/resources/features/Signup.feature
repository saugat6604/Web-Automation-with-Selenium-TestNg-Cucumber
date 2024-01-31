Feature: Login

  Background:
    Given GV Web application is open

  @Auth
    Scenario: User can Signup and enter in to GVWeb with new email and password
      And user verifies Login page
      And user verifies email from backend
      And user enters  previously registered and  correct password
      And user clicks on login button

    @Auth
    Scenario: User is redirected to email verification page after signup
      And user verifies Login page
      And user clicks on signup button of Login page
      And user enters  new username and  correct password
      And user confirms terms and condition
      And user clicks on signup button of Signup page
      Then user verifies email verification page





