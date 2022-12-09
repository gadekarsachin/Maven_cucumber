Feature: login with parameterised user


#datatable
@parameterised
Scenario: validate the functionality with login page
Given user should be at login page
When put the valied value for
|sachin@12		|		0000|
And click the login button
Then get error


@parameterisedMap
Scenario: validate the functionality with login page
Given user should be at login page
When entermap the valied value help of Map
|username |		password	|
|sachin@12		|		0000|
And click the login button
Then get error


