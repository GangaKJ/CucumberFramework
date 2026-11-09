Feature: Login using Data Table

 Scenario: User Login with different credentials
    Given Login page was launched
    When I enter the following credentials
      | username | password    |
      | student  | Password123 |
      | stu      | Password123 |
      | student  | Test123     |
