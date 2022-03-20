Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: CheckOut Experience for product page in both home and Offers page
    Given User is on SwagLabs Login page
    And User logged in with valid credentials
    When User added to cart the product <Name>
    And Validated the details in Shopping cart
    And Entered the delivery information and confirmed the order
    Then The Thank You confirmation message is displayed

    Examples:
    | Name |
    | Sauce Labs Backpack     |
    | Sauce Labs Bolt T-Shirt |
    | My T-Shirt |
