Feature: To verify the Crane request

  @CraneRequest @Regression @NegativeCases
  Scenario: To click All requests button from the menu to click crane
    Given User clicks All requests button from the menu to click crane

  @CraneRequest @Regression @NegativeCases
  Scenario: To click Crane requests button from the menu
    Given User clicks Crane requests button from the menu

  @CraneRequest @Regression
  Scenario: To add new Crane request
    Given User add new Crane request

  @CraneRequest @NegativeCases @Regression
  Scenario: To add a Crane request without mandatory feild
    Given User add a Crane request without mandatory feild

  @CraneRequest @NegativeCases @Regression
  Scenario: To check invalid time error in Crane request
    Given User gives invalid time in Crane request

  @CraneRequest @NegativeCases @Regression
  Scenario: To edit and save a crane request without company in Crane request
    Given User edit and save a crane request without company in Crane request

  @CraneRequest @NegativeCases @Regression
  Scenario: To edit and save a crane request without DFOW in Crane request
    Given User edit and save a crane request without DFOW in Crane request

  @CraneRequest @NegativeCases @Regression
  Scenario: To upload a invalid file in attachment in Crane request
    Given User upload a invalid file in attachment in Crane request

  @CraneRequest @Regression
  Scenario: Search crane request from the list
    Given User search and view the crane request from the list

  @CraneRequest @Regression
  Scenario: Edit a crane request from the list
    Given User edit a crane request from the list

  @CraneRequest @Regression
  Scenario: Filter a crane request from the list
    Given User filter crane request from the list

  @CraneRequest @Regression
  Scenario: User view the Crane request information
    Given User view the Crane request information

  @CraneRequest @Regression
  Scenario: User add a comment to a crane request
    Given User add a comment to a crane request

  @CraneRequest @Regression
  Scenario: User add attachment to the crane request
    Given User add attachment to the crane request

  @CraneRequest @Regression
  Scenario: User view the history of the crane request
    Given User view the history of the crane request

  @CraneRequest @Regression
  Scenario: User complete the request
    Given User complete the request

  @CraneRequest @Regression
  Scenario: User view and approve or reject the crane request
    Given User approve or reject the crane request

  @CraneRequest @Regression
  Scenario: Push a crane request to void
    Given User push a crane request to void
