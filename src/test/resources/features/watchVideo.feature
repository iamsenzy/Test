Feature: I can watch videos without authentication

  Scenario: Not authenticated user
     Given I have opened the browser
     When I maximize the window
     And I open the youtube website
     When I click the first video
     Then It should be display the video
