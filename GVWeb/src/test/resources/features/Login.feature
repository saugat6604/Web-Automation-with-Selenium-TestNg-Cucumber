Feature: Login

  Background:
    Given GV Web application is open

  @Auth
    Scenario: User can login GV Web with valid email and password
      And user verifies Login page
      And user enters  correct username and  correct password
      And user clicks on login button
      Then user verifies Homepage

  @Auth
  Scenario: User cannot login GV Web with valid email and incorrect password
    And user verifies Login page
    And user enters  correct username and  incorrect password
    And user clicks on login button
    Then user verifies incorrect password validation messages

  @Auth
  Scenario: User cannot login GV Web with valid email and empty password
    And user verifies Login page
    And user enters  correct username and  empty password
    And user clicks on login button
    Then user verifies empty password validation messages

    @Auth
    Scenario: User cannot login GV Web with empty email and valid password
      And user verifies Login page
      And user enters  empty username and  correct password
      And user clicks on login button
      Then user verifies empty password validation messages

    @Auth
    Scenario: User cannot login GV Web with empty email and empty password
      And user verifies Login page
      And user enters  empty username and  empty password
      And user clicks on login button
      Then user verifies empty password validation messages

    @Auth
    Scenario: Unverified User cannot login GV Web with email and password
      And user verifies Login page
      And user enters  unverified username and  correct password
      And user clicks on login button
      Then user verifies unverified user validation messages






