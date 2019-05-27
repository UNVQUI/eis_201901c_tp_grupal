Feature: bomb drop

  Scenario: bomb breaks wood walls 3 contingent cells in all direction
    Given Initial map
    And Bomberman drops Bomb as "bomb"
    And place MelaninWall at-1,0- as "melanine"
    And place MelaninWall at-0,2- as "melanine2"
    When 3 Tick passes
    Then "melanine" is destroyed
    Then "melanine2" is destroyed

  Scenario: explosion kills an enemy
    Given Initial map
    And Bomberman drops Bomb as "bomb"
    And place Enemy at-2,0- as "enemy"
    When 3 Tick passes
    Then "enemy" is dead

  Scenario: Explosions don't destroy steel walls
    Given Initial map
    And Bomberman drops Bomb as "bomb"
    And place SteelWall at-0,1- as "steel"
    When 3 Tick passes
    Then "steel" is not destroyed

  Scenario: explosion doesn't kill an enemy because he is too far away from explosion
    Given Initial map
    And Bomberman drops Bomb as "bomb"
    And place Enemy at-4,0- as "enemy"
    When 3 Tick passes
    Then "enemy" is not destroyed

  Scenario: bomberman drops as many bombs as wanted with ProtoMaxUnitsPower
    Given Initial map
    And Bomberman gets ProtoMaxUnitsPower
    And Bomberman drops Bomb as bomb1
    And Bomberman drops Bomb as bomb2
    Then entity bomb1 is at-0,0-
    And entity bomb2 is at-0,0-

  Scenario: bomberman can't drop as many bombs as wanted without ProtoMaxUnits
    Given Initial map
    And Bomberman drops Bomb as "bomb1"
    And Bomberman can't drop bomb

  Scenario: Bombs dropped by bomberman, explodes and disappears
    Given Initial map
    When Bomberman drops Bomb as "bomb1"
    And 3 Tick passes
    And "bomb1" is destroyed

