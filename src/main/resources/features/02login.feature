@login
@regression
Feature: user could log in with valid email and password
  Background: user opens browser to login
    And user navigates to login page

  Scenario: user could log in with valid email and password
    When user fills in email with "jane.doe@gmail.com" and password with "password"
    And user chooses remember me
    And user clicks on login button
  #Expected Result
    Then user could login successfully and goes to the home page