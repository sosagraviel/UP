
Feature: Caja

  Background: Below are the common steps for each scenario
    Given I Launch Chrome Browser
    When I open urupago homepage "http://cobranza.qa.urupago.com.uy/login"
    And User Enter UserName as "rgonzalez" and password as "Password.01"
    And Click on Login
    And Mouse move on Caja


  @SmokeTest @RegressionTest
    Scenario: Apertura de caja Successes
    Then user can view confirmation messages "Urupago - Apertura de caja"
    And close browser