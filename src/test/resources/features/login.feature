Feature: validate the login functionality
@tag1
Scenario: validate the functionality with login page

Given user should be at login page
When put the credential value
And click the login button
Then open a home page

@tag2
Scenario: validate the functionality with login page

Given user should be at login page
When put the credential value
And click the login button
Then open a home page

#you have two scenario u also grouping with the help of tags
#if you want to run only one scenario then you also in feature file like
#tags="@tag2" then only run tag2 scenario