ESTE PROYECTO ES UN TRABAJO DE CLASE Y NO ESTÁ TERMINADO

A continuación se explicarán las reglas. Es posible que falten algunas funciones no testeadas

ChapaGol es un juego de fútbol por turnos. Cada usuario elige qué jugadores mover y que acciones tomar. En cada turno tienes 5 puntos de acción. 
Los puntos de acción sirven para hacer acciones en tu turno (mover a un jugador, regatear, tirar, etc.). Cada acción tiene un coste determinado 
de puntos de acción. Tu turno se acabará si metes gol, si consumes todos tus puntos de acción, si pierdes el control del balón o si das el turno
por finalizado

Objetivo: El objetivo es ganar la ChapaLiga (19 partidos). Cada partido ganado sumará 3 puntos, cada partido empatado sumará 1 punto y cada
partido perdido sumará 0 puntos. 

Ganar un partido: Los partidos se pueden ganar de las siguientes maneras:
-	Por rojas: Si al equipo rival le sacan 3 tarjetas rojas ganarás automáticamente
-	Por goles: Los partidos son al mejor de 4 así que puede haber empate, los posibles resultados son los siguientes: 4-0, 3-1, 2-2, 1-3 y 0-4

Puntos de Acción (PA): Los puntos de acción (de ahora en adelante, PA) indican la cantidad de movimientos que puedes hacer en un turno. Cada vez
que hagas una acción, se descontará el coste de la misma del contador de Puntos de Acción. Al llegar a 0 se cambia el turno


Funciones de administrador: Como administrador puedes añadir jugadores a un equipo, modificar sus estadísticas, moverlos de un equipo a otro o
eliminarlos de un equipo. La idea es hacerlo siguiendo los fichajes de los equipos reales

Funciones de usuario: Puedes modificar tanto la alineación como los titulares de cada equipo y jugar partidos


Acciones:

Acciones disponibles en todo momento (tu equipo controla el balón y tu equipo no controla el balón)
-	Movimiento: Cada movimiento cuesta un PA. Los movimientos pueden ser en horizontal, vertical o diagonal, da igual la dirección. Cada casilla
  que avances consume un PA. Por ejemplo, si mueves a un jugador 3 casillas hacia atrás consumirás 3 PA. Puedes mover cualquier cantidad de jugadores cualquier cantidad de casillas hasta consumir tus PA. Por ejemplo, puedes mover un jugador 5 casillas, puedes mover dos jugadores dos casillas cada uno y luego otro jugador una casilla, o puedes mover 5 jugadores una casilla cada uno.
  Acciones ofensivas (el jugador controla el balón):
-	Regatear: Si tienes a un rival a una casilla de distanciapuedes intentar regatearle. La probabilidad de éxito del regate depende de las 
  estadísticas de ambos jugadores. En caso de conseguirlo cambiarás tu posición con la del jugador regatead, dejándole detrás. En caso de no 
  conseguirlo también intercambiarás posiciones pero el jugador contrario pasará a controlar el balón y se pasará el turno
-	Pasar: Puedes pasar a cualquier jugador de tu equipo sin importar la distancia a la que esté. El éxito del pase depende de la distancia y 
  de las estadísticas del jugador que pasa el balón. Si fallas el pase, el balón puede salir del campo o puede ser interceptado por un rival 
  (si hay alguno alrededor), en cuyo caso acabará tu turno. En caso de que pases a un compañero de equipo que esté en línea con el último defensor 
  contrario, hay una pequeña probabilidad de que haya fuera de juego. Si pasas a un compañero que esté adelantado, habrá fuera de juego. En caso de 
  fuera de juego, un jugador aleatorio sacará el balón desde el punto en el que estaba el jugador que recibió el balón, y el jugador que cometió el 
  fuera de juego se recolocará en una casilla aleatoria.

-	Tirar: Puedes tirar a puerta desde cualquier sitio sin importar la distancia a la que estés. El éxito del tiro dependerá de las estadísticas del 
  rematador, de la distancia a la portería y de la cantidad de jugadores que haya en el área pequeña. Los posibles resultados de un tiro a puerta son:

o	Gol: Se sumará un gol al marcador, se reordenarán los equipos en función de las alineaciones y se cambiará el turno
o	Gol de rebote:  El balón rebota en un defensa y acaba dentro de la portería. Hay una pequeña probabilidad de que suba al marcador como gol en propia puerta
o	Córner: El portero o un defensa despeja el balón y acaba en córner. Los equipos se reordenan y tienes dos puntos de acción más (para centrar y tirar o 
   para hacer una jugada a balón parado si tienes más puntos de acción)
o	El portero coge el balón: El portero rival para el tiro y coge el balón, el turno se cambia directamente
o	Palo: El balón le da al palo. Hay tres posibles resultados:
•	Palo y fuera: Los equipos se reordenan en función de las alineaciones y el portero saca
•	Palo y gol: El tiro acaba en gol, por lo que se suma un gol al marcador, los equipos se reordenan en función de sus alineaciones y el turno se cambia
•	Palo y rebote: El balón acaba en un jugador aleatorio que esté dentro del área. En caso de ser un jugador del equipo atacante, se sumará un punto de 
  acción (para tirar o seguir jugando si tienes más puntos de acción). En caso de que el rebote acabe en control del rival, el turno se cambiará automáticamente
  Acciones defensivas (el jugador no controla el balón)
-	Entrada: Si estás a una casilla de distancia del rival puedes hacerle una entrada. El éxito de la entrada depende de las estadísticas del defensor. 
  Hay cuatro posibles resultados de una entrada:
o	Entrada limpia: Tu jugador recupera el control del balón y se te añade un punto de acción
o	Falta: El árbitro pita falta y se cambia el turno
o	Amarilla: El árbitro pita falta, le saca amarilla al defensor y cambia el turno. Si el defensor ya tenía una amarilla será expulsado
o	Roja directa: Si la falta fue hecha a un rival sin balón, el árbitro pitará roja directa. Si el rival tiene el balón, todavía existe la posibilidad de que el defensor reciba una roja directa, en cuyo caso será expulsado
Si la falta fue hecha dentro del área se pitará penalti. 
