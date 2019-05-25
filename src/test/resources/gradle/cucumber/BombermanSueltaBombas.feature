Feature: Bomberman Suelta Bombas
    
     Scenario: Bomberman pone una bomba y destruye paredes de melamina
        Given Un Juego con bomberman en una celda
        When Bomberman pone una bomba rodeado de paredes de melamina
        And Pasa "3" ticks
        Then La Bomba explota dejando vacio las celdas en un radio de 3 casilleros

     Scenario: Bomberman pone una bomba y mata al enemigo que entra en su onda expansiva
        Given Un Juego con bomberman en una celda
        When Bomberman pone una bomba rodeado de enemigos
        And Pasa "3" ticks
        Then La Bomba explota dejando vacio las celdas en un radio de 3 casilleros

     Scenario: Bomberman pone una bomba y no puede destruir paredes que son de acero
        Given Un Juego con bomberman en una celda
        When Bomberman pone una bomba rodeada de paredes de acero
        And Pasa "3" ticks
        Then La Bomba explota sin romper esas paredes de acero

#Prueba de Aceptacion 3:

     Scenario: Bomberman pone una bomba y mata a "Bagulaa" que entra en su onda expansiva
        Given Un Juego con bomberman en una celda
        When Bomberman pone una bomba con "Bagulaa" al lado
        And Pasa "3" ticks
        Then La Bomba explota donde estaba "Bagulaa" soltando poder "lanzarBombas" en la celda

     Scenario: Bomberman se mueve en una celda donde hay poder "lanzarBombas" y cambia su poder
        Given Un Juego con bomberman en una celda
        And La celda Norte donde esta bomberman hay poder "lanzarBombas"
        When Bomberman se mueve sobre esa celda Norte
        Then Bomberman obtiene el poder "lanzarBombas"

     Scenario: Bomberman con poder "lanzarBombas" lanza bomba a 4 celdas de longitud al Norte
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Norte
        Then La bomba se pone "4" celdas al Norte de la posicion de Bomberman

     Scenario: Bomberman lanza bomba a 4 celda de longitud y al pasar 4 ticks explota
        Given Un Juego con bomberman en una celda
        And Bomberman con poder "lanzarBombas"
        When Bomberman lanza bomba mirando al Norte
        And Pasa "4" ticks
        Then La bomba explota

#Prueba de aceptacion 4:
     #Bomberman.Bomberman suelta bomba y esta alcanza a 'Proto Max Jr.' al morir, este suelta un poder que le permite a bomberman saltar toddo tipo de pared.
      Scenario: Bomberman lanza bomba y esta alcanza a proto max JR, al morir, bomberman puede saltar paredes
         Given Un Juego con bomberman en una celda
         And una pared de metal al sur del bomberman
         And Proto Max Jr al norte del bomberman
         When Bomberman lanza bomba mirando al Norte
         And Pasa "4" ticks
         Then Proto Max Jr muere
         And Bomberman con poder "saltarPared"


#Prueba de aceptacion 5:
   #Bomberman.Bomberman suelta bomba y esta alcanza a 'Proto-Max Units' al morir, este suelta un poder que le permite a bomberman saltar o lanzar varias bombas al mismo tiempo.
   Scenario: Bomberman lanza bomba y esta alcanza a proto max JR, al morir, bomberman puede saltar paredes o lanzar varias bombas al mismo tiempo
      Given Un Juego con bomberman en una celda
      And una pared de metal al Norte del bomberman
      And Proto Max Jr al Sur del bomberman
      When Bomberman lanza bomba mirando al Sur
      And Pasa "4" ticks
      Then Proto Max Jr muere
      And Bomberman con poder "saltarYLanzar"