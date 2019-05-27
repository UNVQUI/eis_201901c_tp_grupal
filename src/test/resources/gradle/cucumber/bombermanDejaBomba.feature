Feature: Bomberman puede poner bombas
 Como jugador dentro del juego
 Quiero dejar una bomba

Scenario: Bomberman intenta poner una bomba que explota y rompe una pared
 
 Given una Celda Con un Bomberman y una celda con una pared de melamina al "Norte"
 When bomberman deja una bomba de "3"
 Then la bomba explota y rompe la pared
 
 
 Scenario: Bomberman pone una bomba que explota y rompe todas las paredes de melamina
 
  Given una Celda con un Bomberman rodeado de paredes de melamina en un radio de 3 celdas
  When bomberman deja otra bomba de "3"
  Then la bomba explota y rompe todas las paredes
  
 Scenario: Bomberman mata a un enemigo
 
 	Given una Celda con un bomberman y un enemigo en la celda al "Norte"
 	When bomberman deja otra bomba de "1"
 	Then la bomba explota y mata al enemigo
 	
 Scenario: Bomberman no rompe pared de acero
 
 	Given una Celda con un bomberman y una pared de acero en la celda al "Norte"
 	When bomberman deja una bomba de "1"
 	Then la bomba explota pero no rompe la pared