Feature: To verify Notification preference functionality

  @Notification @Regression
  Scenario: User login existing account to verify notification feature
    Given User launching the follo web
    And User login existing account

  @Notification @Regression
  Scenario: To select project
    Given User selects the project

  @Notification  @Regression
  Scenario: To navigate to notification preference feature
    Given User clicks notification preference from the menu
    Then Notification preference page should be displayed

  @Notification @instant  @Regression
  Scenario: User updates Notification preference
    Given User selects instant In-app notifications
    And Clicks save changes button

  @Notification @instant 
  Scenario: User updates Notification preference
    Given User selects digest In-app notifications
    And Clicks save changes button
 
  @Notification @Regression
  Scenario: User login existing member account to verify notification feature
    Given User launching the follo web
    And User login existing member account

  @Notification @Regression
  Scenario: To select project
    Given User selects the project

  @Notification @Regression
  Scenario: Member perform changes in the request
    Given Member adds a request
    And Member perform attach, delete, comment, edit and status update a request

  @Notification @Noty @che @Regression
  Scenario: User again login and clicks notification from menu
    Given User launching the follo web
    And User login existing account
    And User selects the project
    And Clicks notification from menu
    Then Notification page should displayed

  @Notification @Noty @Regression
  Scenario: To verify the notification list
    Given User verify the notification list
    And Search the notification
    And Filter the notification
    Then Delete the notification
