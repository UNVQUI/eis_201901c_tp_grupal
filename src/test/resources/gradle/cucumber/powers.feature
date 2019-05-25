Feature: Bomberman powers

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