@compareList
@regression
Feature: Logged user could add different products to compare list

  Background: user opens browser to add products to compare list
    And user enters the login page
    And user keys in "jane.doe@gmail.com", "password"
    And user click login button

  Scenario: logged user could add different products to compareList
    When user chooses Category Electronics
    And user chooses subCategory Cellphones
    And user adds a HTC One to the compareList
  #Expected Result
    Then user adds product successfully to compareList
    And user adds Nokia Lumia to compareList
    And user adds second product successfully to compareList