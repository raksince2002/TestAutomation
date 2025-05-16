#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Booking appointment for every user with their credentials in CuraHealth Services
  I want to book appointment for every user with their credentials in CuraHealth Services

  @tag1
  Scenario: Book appointment for every user
    Given I am in home page of CuraHealth Services and I click on Make Appointment to move to login page
    When I am entering each row details with username, password and I click on Login and I choose the facility, healthcare and date and I click on book appointment and then I either navigate to login page or end the booking session
    Then I display the status of result of each row
