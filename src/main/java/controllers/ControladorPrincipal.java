package controllers;

import domain.Equipo;
import domain.Juego;
import domain.Jugador;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import service.ServiceEquipos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class ControladorPrincipal implements Initializable {
    @FXML
    private BorderPane pantallaPrincipal;
    //LOADERS
    private FXMLLoader loaderLogin = new FXMLLoader();
    private FXMLLoader loaderLandingUsuario = new FXMLLoader();
    private FXMLLoader loaderLandingAdministrador = new FXMLLoader();
    private FXMLLoader loaderSeleccionarEquiposAmigo = new FXMLLoader();
    private FXMLLoader loaderJugarAmigo = new FXMLLoader();
    private FXMLLoader loaderModificarEquipo = new FXMLLoader();
    //CONTROLADORES
    public ControladorLoginPage controladorLoginPage;
    public ControladorLandingUsuario controladorLandingUsuario;
    public ControladorLandingAdministrador controladorLandingAdministrador;
    public ControladorSeleccionarEquiposAmigo controladorSeleccionarEquiposAmigo;
    public ControladorJugarAmigo controladorJugarAmigo;
    public ControladorModificarEquipo controladorModificarEquipo;
    //PANES
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private AnchorPane landingUsuarioAnchorPane;
    @FXML
    private AnchorPane landingAdministradorAnchorPane;
    @FXML
    private AnchorPane seleccionarEquipoAmigoAnchorPane;
    @FXML
    private AnchorPane jugarAmigoAnchorPane;
    @FXML
    private AnchorPane modificarEquipoAnchorPane;
    //CLASES DE LOGICA
    ServiceEquipos serviceEquipos = new ServiceEquipos();
    Juego juego = new Juego();

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serviceEquipos.init();
        cargarLogin(); //CAMBIAR A CARGAR  LOGIN
    }

    public void cargarLogin() {
        try {
            if (loginAnchorPane == null) {
                loginAnchorPane = loaderLogin.load(getClass().getResourceAsStream("/fxml/login_page.fxml"));
                controladorLoginPage = loaderLogin.getController();
                controladorLoginPage.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(loginAnchorPane);
        } catch (IOException e) {
            System.out.println("fallo al cargar login");
        }
    }

    public void cargarLandingUsuario() {
        try {
            if (landingUsuarioAnchorPane == null) {
                landingUsuarioAnchorPane = loaderLandingUsuario.load(getClass().getResourceAsStream("/fxml/landing_usuario.fxml"));
                controladorLandingUsuario = loaderLandingUsuario.getController();
                controladorLandingUsuario.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(landingUsuarioAnchorPane);
            controladorLandingUsuario.init();
        } catch (IOException e) {
            System.out.println("Error al cargar landing usuario");
        }
    }

    public void cargarLandingAdministrador() {
        try {
            if (landingAdministradorAnchorPane == null) {
                landingAdministradorAnchorPane = loaderLandingAdministrador.load(getClass().getResourceAsStream("/fxml/landing_administrador.fxml"));
                controladorLandingAdministrador = loaderLandingAdministrador.getController();
                controladorLandingAdministrador.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(landingAdministradorAnchorPane);
            controladorLandingAdministrador.init();
        } catch (IOException e) {
            System.out.println("Error al cargar landing administrador");
        }
    }

    public void cargarSeleccionarEquipoAmigo() {
        try {
            if (seleccionarEquipoAmigoAnchorPane == null) {
                seleccionarEquipoAmigoAnchorPane = loaderSeleccionarEquiposAmigo.load(getClass().getResourceAsStream("/fxml/seleccionar_equipos_amigo.fxml"));
                controladorSeleccionarEquiposAmigo = loaderSeleccionarEquiposAmigo.getController();
                controladorSeleccionarEquiposAmigo.setBorderPane(this);
            }
            controladorSeleccionarEquiposAmigo.init();
            pantallaPrincipal.setCenter(seleccionarEquipoAmigoAnchorPane);
        } catch (IOException e) {
            System.out.println("Error al cargar seleccionar equipo amigo");
        }
    }

    public void cargarJugarAmigo(String equipoJ1, String equipoJ2) {
        try {
            if (jugarAmigoAnchorPane == null) {
                jugarAmigoAnchorPane = loaderJugarAmigo.load(getClass().getResourceAsStream("/fxml/jugar_amigo.fxml"));
                controladorJugarAmigo = loaderJugarAmigo.getController();
                controladorJugarAmigo.setBorderPane(this);
            }
            // If para comprobar si esta repetido
            Equipo local;
            Equipo visitante;
            local = serviceEquipos.devolverEquipo(equipoJ1);
            visitante = serviceEquipos.devolverEquipo(equipoJ2);
            juego.jugarAmigo(serviceEquipos.devolverEquipo(equipoJ1), serviceEquipos.devolverEquipo(equipoJ2));
            controladorJugarAmigo.init();
            pantallaPrincipal.setCenter(jugarAmigoAnchorPane);
        } catch (IOException e) {
            System.out.println("Error al cargar jugar con un amigo");
        }

    }

    public void cargarModificarEquipo() {
        try {
            if (modificarEquipoAnchorPane == null) {
                modificarEquipoAnchorPane = loaderModificarEquipo.load(getClass().getResourceAsStream("/fxml/modificar_equipo.fxml"));
                controladorModificarEquipo = loaderModificarEquipo.getController();
                controladorModificarEquipo.setBorderPane(this);
                controladorModificarEquipo.init();
            }
            pantallaPrincipal.setCenter(modificarEquipoAnchorPane);
        } catch (IOException e) {
            System.out.println("Error al cargar jugar con un amigo");
        }

    }

    public ObservableList<String> devolverListaEquipos() {
        return serviceEquipos.devolverListaEquipos();
    }

    public TreeSet<Jugador> devolverJugadoresEquipo(String nombreEquipo) {
        return serviceEquipos.devolverJugadoresEquipo(nombreEquipo);
    }

    public Jugador devolverJugador(String nombreJugador, String nombreEquipo) {
        return serviceEquipos.devolverJugador(nombreJugador, nombreEquipo);
    }

    public void cambiarJugadorDeEquipo(String equipoInicial, String equipoFinal, Jugador jugador) {
        serviceEquipos.cambiarJugadorDeEquipo(equipoInicial, equipoFinal, jugador);
    }

    public void eliminarJugador(String nombreEquipo, Jugador jugador) {
        serviceEquipos.eliminarJugador(nombreEquipo, jugador);
    }

    public void anadirJugador(Jugador jugador, String nombreEquipo) {
        serviceEquipos.anadirJugador(jugador, nombreEquipo);
    }

    public Equipo devolverEquipo(String nombreEquipo) {
        return serviceEquipos.devolverEquipo(nombreEquipo);
    }

    public ObservableList<String> devolverListaEquiposJugables() {
        return serviceEquipos.devolverListaEquiposJugables();
    }

    public void sumarPuntos() {
        serviceEquipos.sumarPuntos(juego.getGolesLocal(), juego.getGolesVisitante(), juego.getEquipoLocal(), juego.getEquipoVisitante());
    }

    public void actualizarClasificacion() {
        serviceEquipos.actualizarClasificacion();
    }
}