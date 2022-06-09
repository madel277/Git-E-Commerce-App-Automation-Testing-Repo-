@createOrder
@regression
Feature: user creates successful order

  Background: user opens browser to create an order
    And user navigates to homepage

  Scenario: user creates successful order
    When user selects Category Jewelry
    And user adds Flower Girl Bracelet to the Shopping cart
    And user goes to the Shopping cart
    And user agrees with terms of service
    And user clicks on checkout button
    And user chooses Checkout as a Guest
    And user enters first name "Max"
    And user enters last name "Miller"
    And user fills in email "max.miller@email.com"
    And user selects Country "Egypt"
    And user enters City "Cairo"
    And user enters Address 1 "XY Street"
    And user enters postal code "00000"
    And user enters Phone number "0123456789"
    And user clicks Continue
    And user chooses Shipping method Next Day Air
    And user chooses Continue button
    And user chooses Payment method Credit Card
    And user continues
    And user enters Cardholder name "Max Miller"
    And user enters Card number "4548143477779796"
    And user enters Expiration date "05"/"2026"
    And user enters Card code "552"
    And users clicks again on Continue button
    And user clicks on Confirm button
    #Expected Result
    Then user created order successfully
