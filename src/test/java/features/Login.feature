Feature: Verify Login functionality

  Scenario Outline: Verify user cannot login with invalid data
    Given user navigates to "http://trello.com"
    And user clicks login button
    When user enters username as "<username>"
    And user enters password as "<password>"
    And user clicks on Submit button
    Then user sees error popup

    Examples:
      | username                | password      |
      | not_user_nuNetguru      | Pass1234      |
      | siksterkashop@gmail.com | notMyPassword |