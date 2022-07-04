Feature: To verify the Login feature

  @Login @Regression @ForgotPassword @NegativeCases 
  Scenario: Launch the app URL and navigate to login page
    Given User launching the webapp url
    And User clicks the Login button
    Then User should see login page

  @Login @NegativeCases @Regression 
  Scenario: Login With without credentials
    Given User tries to login without credentials

  @Login @NegativeCases @Regression
  Scenario: Invalid Email Format Error
    Given User gives invalid email format

  @Login @NegativeCases @Regression
  Scenario: Invalid Password Error
    Given User gives invalid Password

  @Login @NegativeCases @Regression
  Scenario: To check for Broken Links and images in Login page
    Given Broken Links in the Login page to be checked
    And Broken images in the Login page to be checked

  @Login @NegativeCases @Regression 
  Scenario: User logging in with valid credentials
    Given User enter mail Id and password
    And User clicks the signin button
    Then User should see the login success message

  @Login @NegativeCases @Regression 
  Scenario: To select project
    Given User selects the project

  @ForgotPassword
  Scenario: User opts for forgot password link
    Given User clicks forgot password
    And User enters mailId in the email feild
    And User clicks the submit button
    Then User should success message
