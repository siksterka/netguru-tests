Feature: Verify Sign Up functionality

  Scenario Outline: Verify user cannot register with already registered email
    Given user navigates to "http://trello.com"
    And user clicks Sign up button
    When user fills in name as "<username>"
    And user fills in email as "<email>"
    And user fills in password as "<password>"
    And user clicks on Sign Up button
    Then user sees error popup for email with message
    |Email already in use by another account. You can use log in or use the forgot password page to reset your password.|

  Examples:
  |username|password|email|
  |newUser666|Pass1234|siksterkashop@gmail.com|