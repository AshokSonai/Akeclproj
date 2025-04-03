Feature: Book Application Login

  Scenario Outline: User login with valid credentials
    Given User should navigate to app
    And enter username "<username>"
    And enter password "<password>"
    When user click login
    Then login should go
    

    Examples:
      | username            | password |
      | admin@yourstore.com | admin    |
      | invalid | invalid |
      | admin@yourstore.com | pddd |
      | admisecomsstore.com|  |

  #Scenario Outline: User login with invalid credentials
    #Given User should navigate to app
    #And enter username "<username>"
    #And enter password "<password>"
    #When user click login
    #Then login should not go
#
    #Examples:
      #| username | password |
      #| invalid | invalid |