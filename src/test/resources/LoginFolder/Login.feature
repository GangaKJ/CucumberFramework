Feature: Login Testing

  Background: 
    Given Application login page

  Scenario: validCredentials
    When user provide  credentials "student" and "Password123"
    And clicks submit button
    Then Success message "https://practicetestautomation.com/logged-in-successfully/"

  Scenario: invalid username
    When user provide  credentials "stude" and "Password123"
    And clicks submit button
    Then Error message "Your username is invalid!"

  Scenario: invalid password
    When user provide  credentials "student" and "Password12"
    And clicks submit button
    Then Error message "Your password is invalid!"

  Scenario: blank inputs
    When clicks submit button
    Then Error message "Blank inputs"
