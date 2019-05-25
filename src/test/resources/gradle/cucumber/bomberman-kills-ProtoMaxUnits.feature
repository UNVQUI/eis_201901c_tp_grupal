Feature: Bomberman drops bomb and reaches Proto Max Units

    Scenario: reaches Proto Max Units
        When Proto Max Units is at 1 cell distance to Bomberman
        And Bomberman drops a bomb
        Then Proto Max Units deads
        And Bomberman either can jump walls or Bomber can drop multiple bombs

     Scenario: doesn't reach Proto Max Units
            When Proto Max Units is at 4 cell distance to Bomberman
            And Bomberman drops a bomb
            Then Proto Max Units is alive
            And Bomberman neither can jump walls nor Bomber can drop multiple bombs