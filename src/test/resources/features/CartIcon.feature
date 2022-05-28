@cartIcon
Feature:You should be able to add items that have the shopping cart icon to your cart and checkout.

  Scenario:
    Given user is on the main page
    Then user should be able to click product with cart icon
    Then user should click add to cart
    And user verifies products have conventional e-commerce functionality
    Then user should be able to checkout
