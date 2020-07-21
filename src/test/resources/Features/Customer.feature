@Test
Feature: Customers


  Background: Below are the common steps for each scenario
    Given I Launch Chrome Browser
    When I open urupago homepage
    And User Enter UserName and password
    And Click on Login
    Then User Can view Dashboad
    When User click on customer menu
    And Click on Add new button
    Then user can view add customer page

#All-426:Creado cajero
  @SmokeTest @RegressionTest
  Scenario: Add Customers
    When User enter customer info
    And click on save button
    Then user can view confirmation message "Urupago - Usuarios"
    And close browser
#All-427:CrearCajeroDoble
  @SmokeTest
  Scenario: Add Same Customers User
    When User enter customer info same user
    Then user can view confirmation message error "Usuario no disponible"
    And close browser
#All-427:CrearCajeroDoble
  @SmokeTest
  Scenario: Add Same Customers Email
    When User enter customer info same email
    Then user can view confirmation message error "Usuario no disponible"
    And close browser
  #All-428:Creado cajero CamposVac'ios
  #All-434:Botón Cancelar
  @SmokeTest
  Scenario: Add customer with blank fields
    When User enter customer info in blank
    Then click on save button disable
    And close browser

  @SmokeTest
  Scenario: Cancel Customers
    When User enter customer info
    And click on cancel button
    Then User should found email in the search table
    And close browser
  @Ignore
  Scenario: Search Customer by Email
    When User click on customer menu
    And Click on customers menu item
    And Enter Customer Email
    When click on search button
    Then User should found email in the search table
    And close browser
  @Ignore
  Scenario: Search Customer by Name
    When User click on customer menu
    And Click on customers menu item
    And Enter Customer first name
    And Enter Customer Last name
    When Click on Search Button
    Then User should found the name in the Search Table
    And close browser
