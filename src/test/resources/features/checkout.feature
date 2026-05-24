Feature: Checkout Functionality

Scenario: Complete checkout process successfully

Given User opens checkout application
When User searches product for checkout
And User adds product for checkout
And User opens checkout page
And User enters billing details
And User selects shipping method
And User selects payment method
And User confirms order
Then Order should get confirmed successfully