@register
@regression
Feature: user could register with valid data

  Background: user opens browser to register
    And user navigates to register page

  Scenario: user could register with valid data
    When user chooses Female as Gender
    And user fills in first name with "Jane"
    And user fills in last name with "Doe"
    And user chooses as birthdate "1" as day and "2" as month and "1990" as year
    And user enters email "jane.doe@gmail.com"
    And user fills in company name with " "
    And user chooses Newsletter
    And user fills in password with "password"
    And user fills in password confirmation with "password"
    And user clicks on register button
  #Expected Result
    Then user could register successfully
    And user clicks on continue button
    And user goes to the home page
