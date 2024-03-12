Feature: Account Page Feature
  Background:
    Given user has already logged in to application
      | username           | password   |
      | saadkhan@gmail.com | welcome123 |

  Scenario: Account page title
    Given user is on account page
    When user gets the title of the page
    Then page title should be "My Account"

  Scenario: Account section count
    Given user is on account page
    Then user gets account section
      | My Account           |
      | My Orders            |
      | My Affiliate Account |
      | Newsletter           |
    And account section count should be 4