Feature: Bomberman se mueve a la celda contigua

    Scenario: Bomberman se mueve hacia el norte
      Given Bomberman
      When Lo muevo de celda hacia el norte
      And  la celda esta vacia
      Then bomberman esta en la proxima celda al norte

  Scenario: Bomberman se mueve hacia el Sur
    Given Bomberman
    When Lo muevo de celda hacia el Sur
    And  la celda esta vacia
    Then bomberman esta en la proxima celda al Sur

  Scenario: Bomberman se mueve hacia el Este
    Given Bomberman
    When Lo muevo de celda hacia el Este
    And  la celda esta vacia
    Then bomberman esta en la proxima celda al Este

  Scenario: Bomberman se mueve hacia el Oeste
    Given Bomberman
    When Lo muevo de celda hacia el Oeste
    And  la celda esta vacia
    Then bomberman esta en la proxima celda al Oeste
