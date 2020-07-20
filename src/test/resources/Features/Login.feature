Feature: Login

  #LoginOK
  @SmokeTest @RegressionTest
  Scenario: Successful Login with Valid Credentials
    Given I Launch Chrome Browser
    When I open urupago homepage "http://cobranza.qa.urupago.com.uy/login"
    And User Enter UserName as "rgonzalez" and password as "Password.01"
    And Click on Login
    Then Page Title Should be "Urupago - Cobros realizados" and "<value>" as "<password>"
    And close browser

    #Login Usuario o contraseña incorrecta
  #Login Usuario o contraseña vacíos
  @SmokeTest @RegressionTest
  Scenario Outline: Unsuccessful Login Data Driven
    Given I Launch Chrome Browser
    When I open urupago homepage "http://cobranza.qa.urupago.com.uy/login"
    And User Enter UserName as "<user>" and password as "<password>"
    And Click on Login
    Then Page Title Should be "Urupago - Login" and "<user>" as "<password>"
    And close browser

    Examples:
      |user|password|value|
      |admin|admin|1|
      ||admin|2|
      |admin||3|

    #Login bloqueo de contraseña con N intentos fallidos
  @RegressionTest
  Scenario Outline: Try N times
    Given I Launch Chrome Browser
    When I open urupago homepage "http://cobranza.qa.urupago.com.uy/login"
    And User Enter UserName as "<user>" and password as "<password>"
    And Click on Login
    Then Page Title Should be "Urupago - Login" and "<value>" as "<password>"
    And close browser

    Examples:
      |user|password|value|
      |one|admin|1|
      |two|admin|2|
      |three|admin|3|