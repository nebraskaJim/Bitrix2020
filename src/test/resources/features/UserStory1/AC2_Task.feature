@reg
Feature: As a user, I should be able to assign tasks by clicking on Task tab under Active Stream.

  Background:
    Given User is on the landing page
    When User logs in as "hr"
    And User clicks on Task tab
  @regression @taskTab @highPriority
  Scenario: User should be able to click on "High Priority" checkbox to set the current task to a top priority task
    When User clicks on High Priority checkbox
    Then Flame image should be lighted up
  @regression @taskTab @editorTask
  Scenario: User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box
    When User clicks on Visual Editor icon
    Then Editor text-bar should be displayed on top of message box in task tab
  @uploadTask
  Scenario: User should be able to create a task with a picture by clicking Upload files and images
    When User clicks on "Upload files" icon
    And User types Task subject
    And User uploads following file:
      |File Path|src/test/resources/testData/Sample.jpeg|
    Then "Task has been created" message should be displayed

  @checklist
  Scenario: User should be able to create on "Checklist" in Checklist icon
    When User types Task subject
    And User clicks Checklist icon under Task tab
    And User adds things to do by clicking add button
    And User clicks on separator button
    And User adds things to do by clicking check mark button
    And User deletes checklist item by clicking on x mark.
    And User clicks on send button to share
    Then "Task has been created" message should be displayed

    @long
  Scenario: . User can assign the tasks to employees by clicking on Add More and selecting contact from E-mail user,
  Employees and Departments and Recent contact lists.
  Employees can be added in different assignment categories: Created By, Participants and Observer.
    When User types Task subject
    And User clicks on Add More button under TASK tab
    And User clicks on Created by button
    And User clicks on Participants button
    And User clicks on +Add button in participants
    And User clicks on "Recent"
    And User clicks on +Add button in observers
    And User clicks on Employees and departments
    And User chooses following emails
      |User1|helpdesk22@cybertekschool.com|
      |User2|helpdesk23@cybertekschool.com|
      |User3|helpdesk24@cybertekschool.com|
    And User click on E-mail users
    And User puts following email
      |Email|helpdesk25@cybertekschool.com|
    And User clicks on send button to share
    Then "Task has been created" message should be displayed








