Feature: Bomberman drops bomb and reaches Proto Max Units

    Scenario: reaches Proto Max Units
        When Proto Max Units is at 1 cell distance to Bomberman
        And Bomberman drops a bomb
        Then Proto Max Units deads
        And Bomberman can jump walls
        And Bomberman can drop multiple bombs

