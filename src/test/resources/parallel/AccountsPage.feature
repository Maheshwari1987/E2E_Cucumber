Feature: Account page Feature

Background:
Given user has already logged in to application
|username|password|
|maheshwarim.mahi@gmail.com|mypwd@123|

@accounts
Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Shop"

@accounts
Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|ADD MY FIRST ADDRESS|
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
And accounts section count should be 5