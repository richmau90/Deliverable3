@All @Admin
Feature: 
	As an Admin
	I want to create and delete users
	So that I can maintain the program
	
Scenario:
	Given the user is not in the system
	When I create the user
	Then the result is created user

Scenario: 
	Given the user is in the system
	When I delete the user
	Then the result is deleted user