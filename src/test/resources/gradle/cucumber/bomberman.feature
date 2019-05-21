Feature: Bomberman movement

  Scenario: Bomberman moves to an empty cell
    Given Empty contingent cell
    When Bomberman moves to contingent cell
    Then Bomberman has moved to contingent cell

  Scenario: Bomberman moves into a wall
    Given Wall in contingent cell
    When Bomberman moves to contingent cell
    Then Bomberman has not moved to contingent cell

  Scenario: Bomberman moves into an enemy
    Given Enemy in contingent cell
    When Bomberman moves to contingent cell
    Then Bomberman is dead