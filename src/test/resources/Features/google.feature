Feature: Google

  @Acceptance
  Scenario: Search Cuba
    Given Open the browser
    When search Cuba
    Then results are shown
