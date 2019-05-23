Feature: Bomberman Moviendose

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
