Feature: CMS dashboard page

  Background: User is logged to the CRM system successfully
    Given User navigate and login with valid account

  @Regression @device_Window_11 @QC_TEAM
  Scenario Outline: Open menu and side menu All product
    Given User navigate to dashboard
    When User click menu "<menu>" and "<subMenu>"
    Then User redirect to this page "<header>"
    Examples:
      | menu     | subMenu         | header          |
      | Products | Add New Product | All New Product |