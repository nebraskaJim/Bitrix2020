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
    # Should user be waiting full 1 hour before attempt to login? If doesn't wait, does 1 hour start over each time?
    # If user had 4 failed attempts at 12:00, 12:02, 12:04, 12:06 and 5th one at 12:12, does 10 minutes count starts over from 12:02 or 12:12?
    # How fast user should choose one of the OTP options and how fast they should verify their identity.









