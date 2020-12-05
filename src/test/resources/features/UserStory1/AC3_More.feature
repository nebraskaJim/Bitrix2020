@more
Feature: As a user, I should be able to create and send workflows by selecting different workflows
  from "More" tab under Activity Stream.

  Background:
    Given User is on the landing page
    When User logs in as "hr"
    And User clicks on More tab

  Scenario:  User should be able to request a Leave Approval by:
  assigning approvers and processors; selecting start and ending date from date picker; select
  Absence type from dropdown; and entering reason for leave information.
    When User clicks on WorkFlow
    And User clicks on Leave Approval and clicks on close button
    And User selects Start Date and End Date
    And User selects Absence Type
    And User states Reason for Leave
    And User clicks on send button to share
    Then Error message below should be displayed
    |message|Workflow parameters need to be configured.|






