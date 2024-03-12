Feature: Account Information Feature
  Scenario Outline: Account Information scenario with different sets of data
    Given user navigates to edit account information page with username "<username>" and password "<password>"
    When user fills the form using given sheet name "<sheetName>" and row number <rowNumber>
    And user clicks on continue button
    Then it shows a successful message "Success: Your account has been successfully updated."
    And user log outs from application and lands on "Account Logout" page

    Examples:
      | username           | password   | sheetName        | rowNumber |
      | saadkhan@gmail.com | welcome123 | Personal Details | 0         |
      | tomhardy@gmail.com | welcome123 | Personal Details | 1         |