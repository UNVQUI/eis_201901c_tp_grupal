Feature: Bomberman se mueve a la celda contigua

    Scenario: Bomberman se mueve hacia el norte
      Given Bomberman
      When Lo muevo de celda hacia el norte
      Then bomberman esta en la proxima celda al norte
