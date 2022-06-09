@color
@regression
Feature: Logged user could filter with color

  Background: user opens browser to select filter color
    And user moves to page to login
    And enters "jane.doe@gmail.com" and "password"
    And clicks on button to login

  Scenario: logged user could filter with color
    When user selects category Apparel
    And user selects subcategory Shoes
    And user selects color red
  #Expected Result
    Then user gets all offered red shoes
    And user selects color grey
    And user gets all offered red and grey shoes
