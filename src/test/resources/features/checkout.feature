
Feature: Checkout Functionality

Background:
Given User opens checkout application


Scenario: Verify checkout page access

When User searches product for checkout
And User adds product for checkout
And User opens checkout page
Then Checkout page should display successfully


Scenario: Enter billing details

When User searches product for checkout 
And User adds product for checkout
And User opens checkout page
Then Billing details section should display


Scenario: Select shipping method

When User searches product for checkout
And User adds product for checkout
And User opens checkout page
Then Delivery details section should display


Scenario: Select payment method

When User searches product for checkout
And User adds product for checkout
And User opens checkout page
Then Payment method section should display


Scenario: Confirm order successfully

When User searches product for checkout
And User adds product for checkout
And User opens checkout page
Then Confirm order button should display