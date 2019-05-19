Feature: Bomberman moves to a cell

  Scenario: the cell is empty
    When the cell is empty
    Then Bomberman changes its position

  Scenario: the cell has a wall
    When the cell has a wall
    Then Bomberman doesn't change its position
