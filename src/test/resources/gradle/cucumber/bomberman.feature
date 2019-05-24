Feature: Bomberman Feature

  Scenario: bomberman se mueve a la celda izquierda que esta vacia
    Given un tablero de 9 x 9
    Given bomberman en una coordenado valida
    When se mueve a la izquierda
    Then bomberman cambio su coordenada