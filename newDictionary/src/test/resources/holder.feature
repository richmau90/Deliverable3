@All @Holder
Feature:
	As a Dictionary Holder/Owner
	I want to publish and unpublish dictionaries 
	So that I can maintain up to date dictionaries

Scenario: publish a dictionary
	Given a dictionary
	And authorization screen
	When I enter y
	Then the dictionary will be authorized

Scenario: unpublish a dictionary 
	Given a dictionary
	And authorization screen
	When I enter n
	Then the dictionary will be unauthorized