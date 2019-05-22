Feature: bomb drop

  Scenario: bomb breakes wood walls 3 contingent cells in all direction
    Given Droped bomb in a cell
    When Bomb explotes after n ticks
    Then Walls are broken 3 cells around

  Scenario: bomb kills an enemy
    Given Droped bomb in a cell
    When Bomb explotes after 3 ticks
    Then Enemy is dead

  Scenario: bomb dont destroy steel walls
    Given Droped bomb in a cell
    When Bomb explotes after n ticks
    Then Steel walls has not been destroyed




