Feature: Login Page Feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Account Login"

  Scenario: Forgot password link
    Given user is on login page
    Then forgotten password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "saadkhan@gmail.com"
    And user enters password "welcome123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My Account"