
Feature: Login functionality

Scenario: Login Error Message -1
	Given I am on the login page
	When I enter a valid username
	And I leave the password field empty
	And I click the login button
	Then I should see an error message
	

	
 