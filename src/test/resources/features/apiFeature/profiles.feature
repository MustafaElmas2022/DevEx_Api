Feature: Retrieving Profiles

  #1.way
  @profile
  Scenario: User able to see all profiles
    Given Users create a GET request and able to see all profiles
    Then Verify that status code is 200


    #2.way
  Scenario: User able to see all profiles 2.way
    Given Users create a GET request and able to see all profiles second way
    Then Verify that status code is 200


    #id 34 , name : Blg , email=sdet_blg@gmail.com, company = Amazon, location:Dortmund

  @oneUser
  Scenario Outline: GET request with path parameter
    Given Users create a GET request with path "<id>"
    Then Verify that status code is 200
    Then Verify that users info "<name>" and "<email>" and "<company>" and "<location>"
    Examples:
      | id | name | email              | company | location |
      | 34 | Blg  | sdet_blg@gmail.com | Amazon  | Dortmund |


