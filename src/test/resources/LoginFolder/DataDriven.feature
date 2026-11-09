Feature: Login data driven

  Background: 
    Given application was launched

  Scenario Outline: Check loginpage with different data sets
    When enter credentials "<username>" and "<password>"
    Then I verify the result in "<expected>"

    Examples: 
      | username | password    | expected                                                     |
      | student  | Password123 | https://practicetestautomation.com/logged-in-successfully/ |
      | stu      | Password123 | Your username is invalid!                                  |
      | student  | assword123  | Your password is invalid!                                 |
      |          |             | Blank inputs                                               |
