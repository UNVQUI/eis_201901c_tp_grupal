Feature: Bomberman drops a bomb

  Scenario: the expansive wave reaches a melanin wall 1 cell distance
    When Bomberman is at 1 cell distance to a melanin wall
    And Bomberman drops a bomb
    Then The wall is destroyed


  Scenario: the expansive wave reaches a melanin wall 2 cell distance
    When Bomberman is at 2 cell distance to a melanin wall
    And Bomberman drops a bomb
    Then The wall is destroyed

  Scenario: the expansive wave reaches a melanin wall 3 cell distance
    When Bomberman is at 3 cell distance to a melanin wall
    And Bomberman drops a bomb
    Then The wall is destroyed

  Scenario: the expansive wave reaches a melanin wall 4 cell distance
    When Bomberman is at 4 cell distance to a melanin wall
    And Bomberman drops a bomb
    Then The wall is not destroyed

  Scenario: the expansive wave reaches an enemy at 1 cell distance
    When Bomberman is at 1 cell distance to an enemy
    And Bomberman drops a bomb
    Then The enemy is killed

  Scenario: the expansive wave reaches an enemy at 2 cell distance
    When Bomberman is at 2 cell distance to an enemy
    And Bomberman drops a bomb
    Then The enemy is killed

  Scenario: the expansive wave reaches an enemy at 3 cell distance
    When Bomberman is at 3 cell distance to an enemy
    And Bomberman drops a bomb
    Then The enemy is killed

  Scenario: the expansive wave reaches an enemy at 4 cell distance
    When Bomberman is at 4 cell distance to an enemy
    And Bomberman drops a bomb
    Then The enemy is not killed