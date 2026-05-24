Feature: Search Product Functionality

Background:
Given User opens search application


Scenario: Search product using valid keyword

When User enters valid product name
And User clicks search button
Then Valid product should display


Scenario: Search product using invalid keyword

When User enters invalid product name
And User clicks search button
Then No product message should display


Scenario: Search product with empty field

When User leaves search box empty
And User clicks search button
Then No product message should display


Scenario: Verify search results

When User enters valid product name
And User clicks search button
Then Search results should display correctly


Scenario: Verify product details

When User enters valid product name
And User clicks search button
And User opens searched product
Then Product details should display successfully