Feature: As a user, I should be able to send messages by clicking on Message tab under Activity Stream
  Background:
    Given User is on the landing page
    When User logs in as "hr"
    And User clicks on "Message" tab
  @activity @login @smoke
  Scenario:User should be able to click on upload files icon to upload files and pictures from local disks,
  download from external drive, select documents from bixtrix24, and create files to upload

    When User clicks on "Upload files" icon
    And User uploads following file:
    |File Path|src/test/resources/testData/Sample.jpeg|
    And User clicks on select document from Bitrix
    And User downloads from external drive
  @contact @activity @smoke
  Scenario:User should be able to add users from selecting contact from E-mail user, Employees and Departments and Recent contact lists.
    When User clicks on Add More button
    And User clicks on "Recent"
    And User clicks on Employees and departments
    And User chooses following emails
    |User1|helpdesk22@cybertekschool.com|
    |User2|helpdesk23@cybertekschool.com|
    |User3|helpdesk24@cybertekschool.com|
    And User click on E-mail users
    And User puts following email
    |Email|helpdesk25@cybertekschool.com|
    Then Number of receivers should be 5
  @activity @link @smoke
  Scenario: User should be able to attach link by clicking on the link icon
    When User clicks on link icon
    And User types following and clicks on save button
    |URL|https://www.google.com/|
    And User clicks on send button to share
    Then URL should be displayed on the main stream
  @activity @video @smoke
  Scenario: User should be able to insert videos by clicking on the video icon and entering the video URL
    When User clicks on Insert video icon
    And User passes following URL into video source and clicks save button
    |URL|https://www.youtube.com/watch?v=2ZUWGoEbbSs|
    And User click on send button
    Then Video should be displayed on the main stream
  @activity @quote @smoke
  Scenario: User should be able to create a quote by clicking on the Comma icon
    When User clicks on Comma icon
    And User passes following quote
    |Quote|Impossible is nothing|
    And User clicks on send button to share
    Then Quote should be displayed on the main stream
  @activity @mention @smoke
  Scenario: User should be able to add mention by clicking on the Add mention icon and select contacts from the lists provided in dropdown
    When User clicks on Add mention icon
    And User clicks on Employees and departments
    And User chooses following email
    |Email|helpdesk23@cybertekschool.com|
    And User clicks on send button to share
    Then email should be displayed on the main stream
  @activity @editor @smoke @mention
  Scenario: User should be able to click on Visual Editor and see the editor text-bar displays on top of the message box.
    When User clicks on Visual Editor icon
    Then Editor text-bar should be displayed on top of message box
  @activity @topic @smoke
  Scenario: User should be able to click on the Topic icon to see the Message Topic text box displays on top of the message box.
    When User clicks on topic icon
    Then Topic text box should be displayed on top of message box
  @activity @recordVideo @smoke
  Scenario: User should be able to click on "Record Video" tab to record a video and attach it with the message
    When User clicks on Record Video icon
    And User allows device to accept to camera and mic
    Then Error message should be displayed






















