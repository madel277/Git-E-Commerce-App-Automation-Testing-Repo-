@reset
@regression
Feature: user could reset his/her password successfully

  Background: user opens browser to reset password
    And user enters login page

  Scenario: user could reset his/her password successfully
    When user clicks on Forget Password?
    And user types email "jane.doe@gmail.com"
    And user clicks on recover button
  #Expected Result
    Then user resets password successfully