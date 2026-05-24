
Feature: Shopping Cart Functionality

Background:
Given User opens cart application


Scenario: Add product to cart

When User searches product for cart
And User adds product to cart
Then Product should get added successfully


Scenario: Update product quantity

When User searches product for cart
And User adds product to cart
And User opens shopping cart
And User updates product quantity
Then Product quantity should get updated


Scenario: Remove product from cart

When User searches product for cart
And User adds product to cart
And User opens shopping cart
And User removes product from cart
Then Shopping cart should become empty


Scenario: Verify total amount

When User searches product for cart
And User adds product to cart
And User opens shopping cart
Then Product total amount should display


Scenario: Verify empty cart message

When User opens shopping cart
Then Empty cart message should display