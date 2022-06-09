@search
@regression
Feature: logged user could search for any product

  Background: user opens browser to search products
  And user goes to login page
  And user logs in with email "jane.doe@gmail.com" and password "password"
  And user logs in by clicking login button

  Scenario: logged user could search for any product using simple search text box
    When user types "laptop" in search box
    And user clicks on search button
  #Expected Result
    Then user goes to search page

  Scenario: logged user could search for any product using advanced search
    When user fills in "laptop" in search box
    And user clicks search button
    And user clicks on advanced search
    And user chooses "Computers" as Category
    And user clicks on Automatically search sub categories
    And user chooses "HP" as Manufacturer
    And user chooses Search In product description
    And user clicks on advanced search button
  #Expected Result
    Then search result will be shown to user
