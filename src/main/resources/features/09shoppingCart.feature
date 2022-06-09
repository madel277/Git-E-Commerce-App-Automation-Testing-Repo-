@shoppingCart
@regression
Feature: Logged user could add different products to Shopping cart

  Background: user opens browser to add products to shopping cart
    And enters login page
    And keys in "jane.doe@gmail.com" and "password"
    And user could click the button to login

  Scenario: logged user could add different products to Shopping cart
    When user clicks on Category Jewelry
    And user adds Bracelet to the Shopping cart
  #Expected Result
    Then user adds product successfully
    Then user clicks on Category Books
    And user adds Pride and Prejudice to the Shopping cart
    And user adds second product successfully to Shopping cart
