@All @Admin
Feature: 
	As an Admin
	I want to build a dictionary 
	So that users can use the program

Scenario: Building the dictionary correctly
	Given the dictionary text file
	When the program executes the build
	Then the result is success

Scenario: Building the dictionary incorrectly
	Given a missing dictionary text file
	When the program executes the build
	Then the result is failed
