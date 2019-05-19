Feature: Bomberman drops a bomb

  Scenario: the expansive wave reaches a melanin wall 1 cell distance
    When Bomberman drops a bomb at 1 cell distance to a melanin wall
    Then The wall is destroyed


  Scenario: the expansive wave reaches a melanin wall 2 cell distance
    When Bomberman drops a bomb at 2 cell distance to a melanin wall
    Then The wall is destroyed

  Scenario: the expansive wave reaches a melanin wall 3 cell distance
    When Bomberman drops a bomb at 3 cell distance to a melanin wall
    Then The wall is destroyed

  Scenario: the expansive wave reaches a melanin wall 4 cell distance
    When Bomberman drops a bomb at 4 cell distance to a melanin wall
    Then The wall is not destroyed