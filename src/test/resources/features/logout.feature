
Feature: Logout Functionality

Background:
Given User opens application
When User navigates to login page
And User enters valid email and password
And User clicks on login button

Scenario: Verify logout functionality

When User clicks on logout option
Then User should logout successfully

Scenario: Verify session termination

When User clicks on logout option
And User clicks browser back button
Then User should not access account page

Scenario: Verify navigation to home page after logout

When User clicks on logout option
And User navigates to home page
Then Home page should display successfully