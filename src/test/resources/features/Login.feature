Feature: Does YouTube Login works?

  Scenario: I can log in to YouTube
    Given I have opened the browser
    When I maximize the window
    And I open the youtube website
    And I click on the Log In button
    Then I should be redirected to the login page
