
Feature: Testing Username and Password in SmartHomes Webpage
  I want to run tests on smarthome webpages with valid and invalid credentials

Background:
    Given user is on login page
    
  Scenario: the user should be able to login with correct username and password
    When user enters correct username and password
    Then user gets confirmation

  Scenario Outline: checking login page with valid and invalid credentials
 	When user enters correct email <username> 
 	And user enters correct password <password>
  Then user gets confirmation

    Examples: 
      | username   | password   |
      | 14A21A0522 | 14A21A0522 |
      | invalid    |     pass   |