Feature: To verify the Crane calendar

  @CraneCalendar @Regression @NegativeCases @Check @Error
  Scenario: To click Crane calendar button from the menu
    Given User clicks Crane calendar button from the menu
    Then Crane calendar page should display

  @CraneCalendar @Regression 
  Scenario: To add new crane request
    Given User add new crane request

  @CraneCalendar @NegativeCases @Regression 
  Scenario: To add a crane request without mandatory feild
    Given User add a crane request without mandatory feild

  @CraneCalendar @NegativeCases @Regression 
  Scenario: To check invalid time error in Crane Calendar
    Given User gives invalid time in Crane calendar

  @CraneCalendar @NegativeCases @Regression 
  Scenario: To edit and save a crane request without company in Crane Calendar
    Given User edit and save a crane request without company in Crane Calendar

  @CraneCalendar @NegativeCases @Regression @Error
  Scenario: To edit and save a crane request without DFOW in Crane Calendar
    Given User edit and save a crane request without DFOW in Crane Calendar

  @CraneCalendar @NegativeCases @Regression @Error
  Scenario: To upload a invalid file in attachment in Crane Calendar
    Given User upload a invalid file in attachment in Crane Calendar

  @CraneCalendar @Regression 
  Scenario: Search crane request
    Given User search and view the crane request in calendar settings

  @CraneCalendar @Regression 
  Scenario: Edit a Crane request from the list
    Given User edit a Crane request from the list

  @CraneCalendar @Regression 
  Scenario: Filter a Crane request from the list
    Given User filter the Crane request from the list

  @CraneCalendar @Regression 
  Scenario: User view Crane request information
    Given User view Crane request information

  @CraneCalendar @Regression 
  Scenario: User add a comment to a crane request
    Given User add a comment to a crane request in calendar settings

  @CraneCalendar @Regression 
  Scenario: User add attachment to the Crane calendar request
    Given User add attachment to the crane calendar request

  @CraneCalendar @Regression 
  Scenario: User complete the crane request
    Given User complete the crane requestt in calendar settings

  @CraneCalendar @Regression @Check 
  Scenario: User view and approve or reject the crane request
    Given User approve or reject the crane request in calendar settings

  @CraneCalendar @Regression @Error
  Scenario: Push a crane request in calendar settings to void
    Given User a crane request in calendar settings to void
