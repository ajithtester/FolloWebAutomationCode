Feature: To verify the Register feature

  @Register @Regression @NegativeCases 
  Scenario: Launch the app URL and navigate to register popup
    Given User launching the web url
    When User clicks the get-started button
    Then User should see welcome popup

  @Register @NegativeCases @Regression
  Scenario: Register Without credentials in register
    Given User tries to register without credentials in register

  @Register @NegativeCases @Regression
  Scenario: Invalid Email Format Error in register
    Given User gives invalid email format in register

  @Register @NegativeCases @Regression
  Scenario: Already used mailId and phone number
    Given User enters already used mail Id and Phone number

  @Register @Regression
  Scenario: Filling the mailId and phone number
    Given User enter mail Id and Phone number
    And User Clicks the continue button
    Then User should see the basic details popup

  @Register @Regression
  Scenario: Filling the basic details
    Given User fills the basic details and clicks continue button
    Then User should see the project details popup

  @Register @Regression
  Scenario: Filling the project details
    Given User fills the project name and address
    And User click next button
    Then User should see the subscription plan page

  @Register @Regression
  Scenario: User selects the subscription plan
    Given User selects the subscription plan
    Then User should redirected to the login page
