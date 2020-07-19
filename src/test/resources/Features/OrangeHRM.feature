Feature: Logging Page

  Scenario: Successful Login with Valid Credentials
    Given I Launch Chrome Browser
    When I open orange hrm homepage "http://admin-demo.nopcommerce.com/login/"
    Then I verify that the logo  present on page
    And close browser