@All @User
Feature: 
	As a User
	I want use the program
	So that I can do work
	
Scenario: enter a prefix
	Given an input screen
	When I enter a prefix
	Then the result will be a prefix

Scenario: enter a word
	Given an input screen
	When I enter a word
	Then the result will be a word

Scenario: enter a prefix word
	Given an input screen
	When I enter a prefix word
	Then the result will be a prefix and word

Scenario: enter a word not found
	Given an input screen
	When I enter an invalid
	Then the result will be not found