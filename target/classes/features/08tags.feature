@tag
@regression
Feature: Logged user could select different tags

  Background: user opens browser to select tags
    And moves to login page
    And enters "jane.doe@gmail.com" "password"
    And clicks on login

  Scenario: logged user could select different tags
    When user selects category Computers
    And user selects tag compact
  #Expected Result
    Then user gets all products tagged with compact
    And user selects tag camera
    And user gets all products tagged with camera