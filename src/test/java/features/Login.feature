Feature: Verify Login functionality

  Scenario Outline: Verify user cannot login with not existing credentials
    Given user navigates to "http://trello.com"
    And user clicks login button
    When user enters username as "<username>"
    And user enters password as "<password>"
    And user clicks on Submit button
    Then user sees error popup for username with message
      |There isn't an account for this username|

  Examples:
  |username|password|
  |example_not_123|Pass1234|