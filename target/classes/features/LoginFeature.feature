
Feature: Login functionality

Scenario: Login Error Message -1
	Given I am on the login page
	When I enter a valid username
	And I leave the password field empty
	And I click the login button
	Then I should see an error message
	
Scenario: Login to Salesforce -2
	Given I am on the login page
	When I enter a valid username
	And I enter a valid password
	And I click the login button
	Then I should be redirected to the home page

Scenario: Check Remember Me -3
	Given I am on the login page
	When I enter a valid username
	And I enter a valid  password
	And I select the "Remember Me" checkbox
  And I click the login button
  Then I should be redirected to the home page
  And I log out
  Then I should see the login page again
  And the username field should be populated
  And the "Remember Me" checkbox should be checked

  Scenario: Forget Password - 4A
    Given I am on the login page
    When I click the "Forget Password" link
    Then I should be redirected to the forget password page
    When I request to reset my password
    Then I should see the "Check Your Email" confirmation page

  Scenario: Forget Password - 4B
    Given I am on the login page
    When I enter an invalid username
    And I enter an invalid password
    And I click the login button
    Then I should see an error message