@All @User
Feature:
	As a User
	I want to login 
	So that I can use the program

Scenario: correct name and correct password
	Given a user login screen
	When I enter the correct name
	And correct password
	Then the result will be User Log In Successfully!!

Scenario: correct name and incorrect password
	Given a user login screen
	When I enter the correct name
	And incorrect password
	Then the result will be Failed!! Wrong Password.

Scenario: incorrect name and correct password 
	Given a user login screen
	When I enter the incorrect name
	And correct password
	Then the result will be Failed!! Wrong User Name.

Scenario: incorrect name and incorrect password
	Given a user login screen 
	When I enter the incorrect name
	And incorrect password
	Then the result will be Failed!! Wrong User Name and Password