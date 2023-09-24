@Login
Feature: Login page feature

ScenarioBackgound: user is on login page

@Smoke
Scenario: Login page Title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Shop"

@Smoke
Scenario: Forget password
Given user is on login page
Then forgot your password link should be displayes

@Regression @Skip
Scenario: Login with proper credentials
Given user is on login page
When user enter the username "maheshwarim.mahi@gmail.com"
And user enters password "mypwd@123"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Shop"