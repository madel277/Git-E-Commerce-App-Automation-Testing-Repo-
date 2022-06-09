@wishList
@regression
Feature: Logged user could add different products to Wishlist

  Background: user opens browser to add products to wish list
    And enters the login page
    And keys in "jane.doe@gmail.com", "password"
    And user click the login button

  Scenario: logged user could add different products to WishList
    When user selects Category Electronics
    And user selects subCategory Cellphones
    And user adds a Nokia Lumia to the WishList
  #Expected Result
    Then user adds product successfully to WishList
    And user chooses Category Computers
    And user chooses subCategory Notebooks
    And user adds HP Notebook to WishList
    And user adds second product successfully to WishList
