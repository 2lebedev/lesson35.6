Feature: Test registration form on 'knigavuhe.org' website

  Scenario: Validate registration form is working in positive scenario

    Given browser is open
    And user is on a website registration page
    When user enters correct registration data in form
    And click on 'Зарегистрироваться' button
    Then user is navigated to 'Profile' page on a website
