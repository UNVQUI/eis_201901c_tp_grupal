Feature: Bomberman luego de matar a bagulaa Obtiene el poder de lanzar bombas .
  Como bomberman quiero poder Lanzar Bombas



  Scenario: Bomberman obtiene el poder de lanzar bombas
    Given Bomberman tiene a Bagulaa en una celda al "Norte" de la que se encuentra
    When Bomberman deja una bomba "3" ticks y se mueve al "Sur"
    Then Explota la bomba y muere Bagulaa . Bomberman obtiene el Poder

  Scenario: Bomberman ya con el poder obtenido , lanza una bomba a 1 celda de distancia al Norte y rompe
  una pared de Melamina que se encuentra a 2 celdas de distancia

    Given Bomberman quiere romper una pared de melamina que se encuentra a 2 celdas de distancia
    When Bomberman lanza una bomba "3" ticks en direccion "Norte" a "1" celda de Distanica
    Then La bomba explota y La pared de Melamina que se encontraba 2 celdas de distancia se destruyo