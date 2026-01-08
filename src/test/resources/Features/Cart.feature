Feature: Cart Functionality

  @cart
  Scenario: Add HP product to cart
    Given User navigates to OpenCart home page
    When User navigates to login page
    When User logs in using valid credentials
    Then User should be logged in successfully
    When User searches product "HP"
    And User adds product "HP LP3065" to cart
    Then Product should be added to cart successfully
