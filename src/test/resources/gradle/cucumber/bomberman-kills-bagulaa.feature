Feature: Bomberman drops bomb and reaches Bagulaa

  Scenario: reaches Bagulaa
    When Bagulaa is at 1 cell distance to Bomberman
    And Bomberman drops a bomb
    Then Bagulaa deads
    #And Bomberman activate superBomb