@Order
Feature: Order Placement

  @order1
  Scenario: Confirm order for HP product
    Given User navigates to OpenCart home page
    When User navigates to login page
    When User logs in using valid credentials
    Then User should be logged in successfully
    And User has product "HP LP3065" in cart
    When User confirms the order

    When User navigates to order history
    Then Order should be visible in order history
