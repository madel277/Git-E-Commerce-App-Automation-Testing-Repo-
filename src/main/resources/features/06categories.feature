@category
@regression
Feature: Logged user could select different Categories

  Background: user opens browser to select categories
    And user moves to login page
    And user enters "jane.doe@gmail.com" and "password"
    And user clicks on button to login

  Scenario: logged user could select different Categories
    When user selects category Electronics
    And user selects subcategory Cell phones
  #Expected Result
    Then user gets all cellphones shown
