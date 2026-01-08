@homePage
Feature: OpenCart Home Page Validation

  @home1
  Scenario: Validate OpenCart home page basic elements
    Given User navigates to OpenCart home page
    And User validates logo and search box are present


  @home2
  Scenario: Validate header and footer sections
    Given User navigates to OpenCart home page
    Then User validates header links are present
    And User validates footer sections are present


  @home3
  Scenario: Validate main menu items
    Given User navigates to OpenCart home page
    Then User validates main menu options are displayed