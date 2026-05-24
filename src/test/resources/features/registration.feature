
Feature: Registration Functionality

Background:
Given User opens registration application
When User navigates to registration page


Scenario: Verify navigation to registration page

Then User should navigate to registration page successfully


Scenario: Register user with valid details

And User enters all mandatory registration fields
And User clicks continue button
Then User account should get created successfully


Scenario: Register user with existing email

And User enters existing email details
And User clicks continue button
Then User should see duplicate email warning


Scenario: Verify mandatory field validation messages

And User clicks continue button
Then User should see all mandatory field warnings


Scenario: Verify password mismatch validation

And User enters password and mismatched confirm password
And User clicks continue button
Then User should see password mismatch warning


Scenario: Verify successful account creation

And User enters all mandatory registration fields
And User clicks continue button
Then User should see account success message