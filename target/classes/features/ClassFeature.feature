Feature: Class feature

#common: given will get executed first before all Scenarios
Background:
Given user launched login page

Scenario:

When User enters valid username 
And User enters valid password
And User Click on login button
Then User should be seeing homepage

#Scenario:
#
#When User enters invalid username 
#And User enters valid password
#And User Click on login button
#Then User should be seeing homepage
#
#Scenario:
#
#When User enters valid username 
#And User enters invalid password
#And User Click on login button
#Then User should be seeing homepage
#
#Scenario:
#
#When User enters invalid username 
#And User enters invalid password
#And User Click on login button
#Then User should be seeing homepage

