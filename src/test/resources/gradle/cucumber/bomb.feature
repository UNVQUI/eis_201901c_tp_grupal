Feature: bomb drop

  Scenario: bomb breaks wood walls 3 contingent cells in all direction
    Given Initial map
    And Bomberman drops Bomb at-0,0-
    And place MelaninWall at-1,0- as "melanine"
    And place MelaninWall at-0,2- as "melanine2"
    When Time passes and Bomb explodes
    Then "melanine" is destroyed
    Then "melanine2" is destroyed

  Scenario: explosion kills an enemy
    Given Initial map
    And Bomberman drops Bomb at-0,0-
    And place Enemy at-2,0- as "enemy"
    When Time passes and Bomb explodes
    Then "enemy" is dead

  Scenario: Explosions don't destroy steel walls
    Given Initial map
    And Bomberman drops Bomb at-0,0-
    And place SteelWall at-0,1- as "steel"
    When Time passes and Bomb explodes
    Then "steel" is not destroyed

  Scenario: explosion doesn't kill an enemy because he is too far away from explosion
    Given Initial map
    And Bomberman drops Bomb at-0,0-
    And place Enemy at-4,0- as "enemy"
    When Time passes and Bomb explodes
    Then "enemy" is not destroyed

   Scenario: bomberman drops as many bombs as wanted
     Given Initial map
     When Bomberman drops Bomb at-0,0- as bomb1
     And drops another Bomb at-0,0- as bomb2
     Then entity bomb1 is at-0,0-
     And entity bomb2 is at-0,0-

   Scenario: Bombs dropped by bomberman, explodes n ticks after they were dropped
     Given Initial map
     When Bomberman drops Bomb at-0,0- as bomb1
     And drops another Bomb at-0,0- as bomb2
     And 3 ticks passes for all bombs and explodes
     Then entity bomb1 is not at-0,0-
     And entity bomb2 is not at-0,0-




