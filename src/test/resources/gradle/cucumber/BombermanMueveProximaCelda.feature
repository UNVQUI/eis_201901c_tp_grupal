Feature: Bomberman

    Scenario: Bomberman se mueve a la celda Norte
       Given Un Juego con bomberman en una celda
       When Bomberman se mueve hacia la celda vacia Norte
       Then Bomberman cambia su posicion

    Scenario: Bomberman no se puede mover habiendo una celda con una pared al Norte
       Given Un Juego con bomberman en una celda
       When Bomberman intenta moverse al Norte habiendo una pared
       Then Bomberman se queda en el lugar

    Scenario: Bomberman muere al moverse a la celda Norte habiendo un enemigo
       Given Un Juego con bomberman en una celda
       When Bomberman intenta moverse al Norte habiendo un enemigo
       Then Bomberman muere

    #Scenario: Bomberman pone una bomba y destruye paredes de melamina
    #   Given Un Juego con bomberman en una celda
    #   When Bomberman pone una bomba rodeado de paredes de melamina
    #   And Pasa "3" ticks
    #   Then La Bomba explota rompiendo paredes de melamina en un radio de 3 casilleros

    #Scenario: Bomberman pone una bomba y mata al enemigo que entra en su onda expansiva
    #   Given Un Juego con bomberman en una celda
    #   When Bomberman pone una bomba rodeado de enemigos
    #   And Pasa "3" ticks
    #   Then La Bomba explota matando a los enemigos que alcanzan la onda expansiva

    #Scenario: Bomberman pone una bomba y no puede destruir paredes que son de acero
    #   Given Un Juego con bomberman en una celda
    #   When Bomberman pone una bomba rodeada de paredes de acero
    #   And Pasa "3" ticks
    #   Then La Bomba explita sin romper esas paredes de acero
