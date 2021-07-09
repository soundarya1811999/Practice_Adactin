Feature: hotel booking 
Scenario Outline: login application

	Given  user wants to Login Application 
	When  user enter "<Username>" username 
	When  user enter "<Password>" password 
	Then  user validate login button
	
Examples:
	
	|Username|Password|
	|aaa|434456|
	|soundaryaharini18|Sun5hin@|