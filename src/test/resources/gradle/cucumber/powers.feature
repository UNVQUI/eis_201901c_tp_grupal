Feature: Bomberman powers

  #/****************************************************************************************/
  #/** Bagulaa *****************************************************************************/
  Scenario: explosion kills Bagulaa
    Given Initial map
    And Bomberman drops Bomb at-0,0-
    And place Bagulaa at-2,0- as "bagulaa"
    When Time passes and Bomb explodes
    Then "bagulaa" is dead

  Scenario: Bomberman gets BagulaaPower
    Given Initial map
    And place BagulaaPower at-2,0- as "power"
    When Bomberman moves to-2,0-
    Then Bomberman has BagulaaPower

  Scenario: Bomberman throws Bomb far away and kills enemy
    Given Initial map
    And Bomberman gets BagulaaPower
    And place Enemy at-2,0- as "enemy"
    When Bomberman throws Bomb to RIGHT -2- cells away as "bomb"
    And Time passes and Bomb explodes
    Then "enemy" is dead

  #/****************************************************************************************/
  #/** ProtoMaxJr **************************************************************************/
  Scenario: explosion kills ProtoMaxJr
    Given Initial map
    And Bomberman drops Bomb at-0,0-
    And place ProtoMaxJr at-2,0- as "protoMaxJr"
    When Time passes and Bomb explodes
    Then "protoMaxJr" is dead

  Scenario: Bomberman gets ProtoMaxJrPower
    Given Initial map
    And place ProtoMaxJrPower at-2,0- as "power"
    When Bomberman moves to-2,0-
    Then Bomberman has ProtoMaxJrPower

  Scenario: Bomberman jumpt to the Right trough the wall to the next free cell
    Given Initial map
    And Bomberman gets ProtoMaxJrPower
    And place MelaninWall at-1,0- as "mWall"
    When Bomberman jump to RIGHT
    Then Bomberman is at-2,0-

  #/****************************************************************************************/
  #/** ProtoMaxUnits ***********************************************************************/
  Scenario: explosion kills ProtoMaxUnits
    Given Initial map
    And Bomberman drops Bomb at-0,0-
    And place ProtoMaxUnits at-2,0- as "protoMaxUnits"
    When Time passes and Bomb explodes
    Then "protoMaxUnits" is dead

  Scenario: Bomberman gets ProtoMaxJrPower
    Given Initial map
    And place ProtoMaxUnitsPower at-2,0- as "power"
    When Bomberman moves to-2,0-
    Then Bomberman has ProtoMaxUnitsPower

  Scenario: Bomberman throws Bomb far away and kills enemy
    Given Initial map
    And Bomberman gets ProtoMaxUnitsPower
    And place Enemy at-0,2- as "enemy"
    When Bomberman throws Bomb to DOWN -2- cells away as "bomb"
    And Time passes and Bomb explodes
    Then "enemy" is dead

  Scenario: Bomberman jumpt to the Right trough the wall to the next free cell
    Given Initial map
    And Bomberman gets ProtoMaxUnitsPower
    And place MelaninWall at-1,0- as "mWall"
    When Bomberman jump to RIGHT
    Then Bomberman is at-2,0-