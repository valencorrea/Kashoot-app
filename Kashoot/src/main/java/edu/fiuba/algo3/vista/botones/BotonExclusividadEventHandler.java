package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    private BotonResponderGeneral botonResponderGeneral;
    private Kashoot kashoot;
    private VistaKashoot vista;
    private Scene proximaEscena;
    private Stage stage;

    public BotonExclusividadEventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage) {
        this.botonResponderGeneral = new BotonResponderGeneral();
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.proximaEscena = escenaFinal;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorActual = this.kashoot.obtenerJugadorActual();
        jugadorActual.responder(vista.getPregunta(),vista.getRespuesta());
        this.kashoot.jugarRondaConExclusividad();
        this.kashoot.obtenerJugadorActual().usarExclusividad();

        this.kashoot.actualizar();

        botonResponderGeneral.actualizar(vista,proximaEscena,stage);
    }
}
