Feature: Bomberman moves to a cell

  Scenario: the cell is empty
    When Bomberman moves to an empty cell
    Then Bomberman changes its position

  Scenario: the cell has a wall
    When Bomberman moves to a cell that has a wall
    Then Bomberman doesn't change its position

  Scenario: the cell has an enemy
    When Bomberman moves to a cell with an enemy
    Then Bomberman dies


