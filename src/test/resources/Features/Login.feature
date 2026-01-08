@logIn
Feature: Login Functionality

  @login1
  Scenario: Validate login page
    Given User navigates to OpenCart home page
    When User navigates to login page
    Then User validates login page fields are present

  @login2
  Scenario: Login with valid credentials
    Given User navigates to OpenCart home page
    When User navigates to login page
    When User logs in using valid credentials
    Then User should be logged in successfully

  @loginFailed
  Scenario: Failed Login scenario
    Given User navigates to OpenCart home page
    Then User validates login page for failed step
