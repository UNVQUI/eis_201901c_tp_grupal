Feature: Bomberman moves to a cell

  Scenario: the cell is empty
    When the cell is empty
    Then Bomberman changes its position
