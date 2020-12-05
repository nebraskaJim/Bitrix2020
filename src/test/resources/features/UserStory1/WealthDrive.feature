@wealth
Feature: Login functionality

  Background:
    Given User is on the login page

  Scenario: Users should be able to login without verification if they have logged in before
    When User enters "email" and "password"
    Then Personal Portfolio Dashboard should be displayed

  Scenario: Users should NOT be able to login without verification if they have never logged in before
    When User enters "email" and "password"
    Then User should see  SMS or EMAIL OPT options displayed

  Scenario Outline:User's account should be locked for 1 hour if they enter wrong credentials 5 times within 10min
    When User enters wrong "<email>" and "<password>" 5 times
    Then "<error message>" message should be displayed and account should be locked
    Examples:
      | email       | password                    | error message     |
      | wrong email | wrong password              | Wrong credentials |
      | wrong email | right password              | Wrong credentials |
      | right email | wrong password              | Wrong credentials |
      | right email | not case sensitive password | Wrong credentials |
      | wrong email | wrong password              | Account blocked   |

  Scenario: User should not be able to login within 1 hour with any credentials after account is locked

  Scenario: User should be able to login with CORRECT credentials after 1 hour
    When User enters "email" and "password"
    Then Personal Portfolio Dashboard should be displayed




    #QUESTIONS

    # What is the time period to consider the user already logged in? If user logged in that day , that hour or if user ever logged in before?
    # Should account be locked at 5th attempt or 6th?
    # Should user be waiting full 1 hour before attempt to login? If doesn't wait, does 1 hour start over each time  user tries to login?
    # If user had 4 failed attempts at 12:00, 12:06, 12:07, 12:08 and 5th one at 12:12, does 10 minutes count starts over from 12:06 or 12:12?
    # How fast user should choose one of the OTP options and how fast they should verify their identity.


    Given "x-api-auth-token" is provided as header
    When User sends request to /users/16a972ce-a800-4a09-b710-97bf18220153/equities
    Then Response status code should be 200
    And "symbol[0]" should be equal to "APPL"
    And "costBasis[1]" should be equal to 726.88
    And "sharesHeld[2]" should be equal to 978

    Given No header is provided
    When User sends request to /users/16a972ce-a800-4a09-b710-97bf18220153/equities
    Then Response status code should be 401
    And Response payload should contain " Not Authorized"

    Given "x-api-auth-token" is provided as header
    When User provides "/users/wrong userID/equities"
    Then Response status code should be 404
    And Response payload should contain "User Not Found"

    Given "x-api-auth-token" is provided as header
    When User sends request to "endpoint" more than 5 times in 10sec
    Then Response status code should be 429

    Given "x-api-auth-token" is provided as header
    When User sends request to /users/16a972ce-a800-4a09-b710-97bf18220153/equities
    And User is not able to reach to server
    Then Response status code should be 500

    Given "x-api-auth-token" is provided as header
    When User sends request to /users/16a972ce-a800-4a09-b710-97bf18220153/equities
    And Server takes too long to execute the request
    Then Reponse status code should be 504


  Scenario: Users should be able to login without verification if they have logged in before
  Scenario: Users should NOT be able to login without verification if they have never logged in before
  Scenario: User should be able to choose OTP option if they haven't logged in before
  Scenario: User's account should be locked for 1 hour if they enter wrong credentials 5 times within 10min
  Scenario: User should not be able to login within 1 hour with any credentials after account is locked
  Scenario: User should be able to login with CORRECT credentials after 1 hour














