Feature: Bomberman puede obtener los poderes de Proto Max Unit tras destruirlo
Como jugador dentro del juego
Quiero poder matar y obtener los poderes del enemigo "Proto Max Unit"
Para poder tener el poder de saltar o lanzar varias bombas a la vez o saltar paredes

Scenario: Bomberman obtiene el Poder de lanzar varias bombas a la vez
Given un bomberman que tiene a un enemigo Proto Max Unit en una celda contigua al "Norte"
And una pared en la celda al "Norte"
When bomberman deja una bomba y esta explota matando a ProtoMaxUnits y su nuevo poder luego de moverse a la celda del "Norte"
Then bomberman obtiene el poder de protoMax Units