Feature: Compare UI and API Experience

  @experience
  Scenario Outline: UI and API Experience
    Given User create a POST request for add an experience with "<title>","<company>","<location>","<from>","<to>","<current>","<description>"
    Then Verify status code is 201
    And Compiler gets the Id
    And User GET request by id from API
    And User is on the Dashboard Page
    Then UI API experience information must be match "Nokia"

    Examples:
      | title    | company | location | from       | to         | current | description |
      | Engineer | Nokia     | Helsinki  | 1992-10-10 | 1993-10-10 | false   | Happy       |




