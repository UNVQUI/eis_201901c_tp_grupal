Feature: Bomberman drops bomb and reaches Proto Max Jr

    Scenario: reaches Proto Max Jr
        When Proto Max Jr is at 1 cell distance to Bomberman
        And Bomberman drops a bomb
        Then Proto Max Jr deads
        And Bomberman can jump walls

    Scenario: doesn't reach Proto Max Jr
        When Proto Max Jr is at 4 cell distance to Bomberman
        And Bomberman drops a bomb
        Then Proto Max Jr is alive
        And Bomberman cant jump walls