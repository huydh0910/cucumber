@CMS
Feature: Login Test CMS

   Background: Navigate to Login page for Admin
      Given User navigate to Login Page for Admin "https://cms.anhtester.com/login"

   @Regression @device_Window_11 @login @QC_TEAM
   Scenario: Login success
      When user enter valid email and valid password
      And click Login button
      Then user is redirected to the Dashboard page

   @Regression @login @QC_TEAM
   Scenario: Login failed
      When user enter invalid email and valid password
      And click Login button
      Then verify popup error is displayed