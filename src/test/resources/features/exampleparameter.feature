Feature: login functionality 
 
 
@parameterisedexample
Scenario Outline:
 validate the functionality with login page
Given user should be at login page
When enter valied input help of <username>and <password>
And click the login button
Then get error

Examples:
 |username	| 	password	|
 |"sachin"	|		"sachingadekar"|
 |"rahes	"	|"ajshh	"	|