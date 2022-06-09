@currency
@regression
Feature: Logged User could switch between currencies US-Euro

  Background: user opens browser to switch between currencies
    And user types login page
    And user logs in with "jane.doe@gmail.com" and "password"
    And user clicks login button

  Scenario: logged user switch between currencies US-Euro
    When user searches for "macbook"
    And user clicks search
    And user chooses currency "Euro" from currency dropbox
  #Expected Result
    Then user get price in Euro
    And user chooses currency "US Dollar" from currency dropbox
    And user get price in US Dollar
