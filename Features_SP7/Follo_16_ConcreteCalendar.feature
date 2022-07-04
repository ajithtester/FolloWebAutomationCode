Feature: To verify the concrete calendar

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: To click Crane Concrete button from the menu
    Given User clicks Crane Concrete button from the menu
    Then Concrete calendar page should display

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: To add new Concrete calendar request
    Given User add new Concrete calendar request

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Search Concrete request
    Given User search the Concrete request in calendar

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Edit a Concrete request from the calendar
    Given User edit a Concrete request from the calendar

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Filter a Concrete request in calendar
    Given User filter the Concrete request in calendar

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: To view info and history, add comment, add attachment to the Concrete calendar request
    Given User view info and history, add comment, add attachment to the Concrete calendar request

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Approve and Complete a concrete request in the calendar
    Given User Approve and Complete a concrete request in the calendar

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Add pump to the concrete request in concrete calendar
    Given User add pump to the concrete request in concrete calendar

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Add new Concrete calendar request without filling mandatory field
    Given User add new Concrete calendar request without filling mandatory field

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Add new Concrete calendar request with invalid date and time
    Given User add new Concrete calendar request with invalid date and time

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Add invalid file in Concrete calendar request
    Given User add invalid file in Concrete calendar request

  @ConcreteCalendar @Regression @Sp7 @Noty
  Scenario: Push a Concrete request from the calendar
    Given User push a Concrete request from the calendar
