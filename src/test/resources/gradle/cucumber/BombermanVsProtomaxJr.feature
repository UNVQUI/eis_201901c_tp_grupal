# new feature
# Tags: optional

Feature: Bomberman puede destruir a Proto Max Jr y obtener el poder de saltar paredes
 Como jugador dentro del juego
 Quiero poder destruir a Proto Max Jr
 Para obtener el poder de saltar paredes


Scenario: Bomberman suelta bomba y esta alcanza a Proto Max Jr

 Given Bomberman suelta bomba y alcanza a Proto Max Jr
 When Proto Max Jr suelta un poder
 Then Bomberman puede saltar todo tipo de pared
