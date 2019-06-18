Feature: Deal Data Creation

Scenario: Free CRM creating a new Deal Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters username and password
|anjuthomas|nvrsynvr|
Then user clicks on login button
Then user is on home page
Then user moves to deals page
Then click on new deal
| test deal | 1000 | 50 | 10 |
Then close the browser
