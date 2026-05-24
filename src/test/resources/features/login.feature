
Feature: Login Functionality

Background:
Given User opens application
When User navigates to login page

Scenario: Login with valid credentials
And User enters valid email and password
And User clicks login button
Then User should login successfully

Scenario: Login with invalid email
And User enters invalid email 
And User enters valid password
And User clicks login button
Then Proper warning message should display

Scenario: Login with invalid password
And User enters valid email
And User enters invalid password
And User clicks login button
Then Proper warning message should display

Scenario: Login with blank credentials
And User clicks login button
Then Proper warning message should display

Scenario: Verify all UI elements on Login page
Then User should see all login page elements