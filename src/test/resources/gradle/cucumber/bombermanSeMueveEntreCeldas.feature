Feature: Bomberman puede intentar moverse entre celdas
 Como jugador dentro del juego
 Quiero moverme entre celdas

Scenario: Bomberman intenta moverse de una celda a una celda contigua vacia
 
 Given un Bomberman con una celda vacia al "Norte"
 When Bomberman se mueve al "Norte"
 Then Bomberman cambia su posicion

Scenario: Bomberman intenta moverse de una celda a una celda contigua ocupada por una pared
 Given un bomberman con una celda ocupada por una pared ubicada al "Norte"
 When Bomberman se mueve al "Norte"
 Then Bomberman no cambia de celda

Scenario: Bomberman intenta moverse de una celda a una celda contigua ocupada por un enemigo
 Given un bomberman con una celda ocupada por un enemigo al "Norte"
 When Bomberman se mueve al "Norte"
 Then Bomberman pasa a estar muerto