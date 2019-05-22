Feature: Movimiento de Bomberman

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

#    Scenario: Bomberman se mueve hacia el norte
#      Given Bomberman
#      When Lo muevo de celda hacia el Norte
#      Then bomberman esta en la proxima celda al Norte

#    Scenario: Bomberman se mueve hacia el Sur
#      Given Bomberman
#      When Lo muevo de celda hacia el Sur
#      Then bomberman esta en la proxima celda al Sur

#    Scenario: Bomberman se mueve hacia el Este
#      Given Bomberman
#      When Lo muevo de celda hacia el Este
#      Then bomberman esta en la proxima celda al Este


#    Scenario: Bomberman se mueve hacia el Oeste
#     Given Bomberman
#      When Lo muevo de celda hacia el Oeste
#      Then bomberman esta en la proxima celda al Oeste