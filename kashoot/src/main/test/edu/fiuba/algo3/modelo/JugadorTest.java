package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JugadorTest {

    @Test
    public void jugadoresRespondenVerdaderoFalsoClasicoRecibenPuntajeCorrecto(){

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()),"hola soy una pregunta??",respuestaCorrecta);
        unJugador.responder(unaPregunta,respuestaCorrecta);
        otroJugador.responder(unaPregunta,respuestaIncorrecta);

        int unResultado = unJugador.getPuntajeAcumulado();
        int otroResultado = otroJugador.getPuntajeAcumulado();

        assertEquals(unResultado, 10);
        assertEquals(otroResultado, 0);
    }
    @Test
    public void jugadoresRespondenVerdaderoFalsoConPenalidadRecibenPuntajeCorrecto(){

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()),"hola soy una pregunta??",respuestaCorrecta);

        unJugador.responder(unaPregunta,respuestaCorrecta);
        otroJugador.responder(unaPregunta,respuestaIncorrecta);

        int unResultado = unJugador.getPuntajeAcumulado();
        int otroResultado = otroJugador.getPuntajeAcumulado();

        assertEquals(unResultado, 10);
        assertEquals(otroResultado, -10);
    }

    @Test
    public void jugadoresRespondenMultipleChoiceClasicoRecibenPuntajeCorrecto(){
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionCorrectaDos);
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()),"hola soy una pregunta??",respuestaCorrecta);

        unJugador.responder(unaPregunta,respuestaUnJugador);
        otroJugador.responder(unaPregunta,respuestaOtroJugador);

        int unResultado = unJugador.getPuntajeAcumulado();
        int otroResultado = otroJugador.getPuntajeAcumulado();

        assertEquals(20, unResultado);
        assertEquals(0, otroResultado);
    }

    @Test
    public void jugadoresRespondenMultipleChoiceParcialRecibenPuntajeCorrecto(){
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");
        Jugador tercerJugador = new Jugador("pepesito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionCorrectaDos);
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Respuesta respuestaTercerJugador = new Respuesta();
        respuestaTercerJugador.agregarOpcion(opcionCorrectaUno);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()),"hola soy una pregunta??",respuestaCorrecta);

        unJugador.responder(unaPregunta,respuestaUnJugador);
        otroJugador.responder(unaPregunta,respuestaOtroJugador);
        tercerJugador.responder(unaPregunta,respuestaTercerJugador);

        int unResultado = unJugador.getPuntajeAcumulado();
        int otroResultado = otroJugador.getPuntajeAcumulado();
        int tercerResultado = tercerJugador.getPuntajeAcumulado();

        assertEquals(20, unResultado);
        assertEquals(0, otroResultado);
        assertEquals(10, tercerResultado);
    }

    @Test
    public void jugadoresRespondenMultipleChoiceConPenalidadRecibenPuntajeCorrecto(){
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()),"hola soy una pregunta??",respuestaCorrecta);

        unJugador.responder(unaPregunta,respuestaUnJugador);
        otroJugador.responder(unaPregunta,respuestaOtroJugador);

        int unResultado = unJugador.getPuntajeAcumulado();
        int otroResultado = otroJugador.getPuntajeAcumulado();

        assertEquals(20, unResultado);
        assertEquals(-10, otroResultado);
    }
}

