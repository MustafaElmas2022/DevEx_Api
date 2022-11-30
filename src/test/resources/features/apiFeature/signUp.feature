Feature: Sign Up

  @wip
  Scenario Outline: User Register
    Given Users create A POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then Verify status code is 200
    Then Verify that body contains "token"
    And Compiler gets the token


    Examples:
      | email           | password | name  | google  | facebook | github |
      | fernandeswho@yahoo.com| Test321  | Fernandeswho | SteveG | BFace    | BiGit  |

  Scenario Outline: User can able to POST the Token
    Given User create a POST request and send the token with "<company>" "<website>" "<location>" , "<status>" , "<skills>","<githubusername>", "<youtube>" , "<twitter>" , "<facebook>" , "<linkedin>" and "<instagram>"
    Then Verify status code is 200
    Then User verify that name as "Fernandeswho" and email as "fernandeswho@yahoo.com"

    Examples:
      | company | website | location | status    | skills             | githubusername | youtube | twitter  | linkedin | instagram |
      | AppleIOS     | appleios.com | New York   | Developer | HTML,Cucumber,JAVA | Brc_Github     | BRC_You | BRC_Twit | BRC_Link | BRC_Ins   |


