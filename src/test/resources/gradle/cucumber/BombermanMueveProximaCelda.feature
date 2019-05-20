Feature: Bomberman se mueve a la celda contigua

    Scenario: Bomberman se mueve a la celda Norte
       Given Un Juego que contiene mapa con Bomberman en su celda inicial
       When Bomberman se mueve hacia la celda vacia Norte
       Then Bomberman cambia su posicion

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