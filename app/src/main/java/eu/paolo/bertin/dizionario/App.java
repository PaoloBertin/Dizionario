package eu.paolo.bertin.dizionario;

import eu.paolo.bertin.dizionario.controller.FXMLController;
import eu.paolo.bertin.dizionario.model.Parole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class App extends Application {

    private static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        log.trace("start applicazione");

        // carica la vista e la assegna al nodo radice
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/scene.fxml"));
        Parent root = loader.load();

        // crea la scena
        Scene scene = new Scene(root);
        // carica il foglio di stile associato alla vista
        scene.getStylesheets()
             .add("/styles/styles.css");

        // costruisce il controller associato alla vista
        FXMLController fxmlController;
        fxmlController = loader.getController();

        // crea il modello e lo rende disponibile al controller della vista
        // il modello e' creato qui in modo sia visibile, in generale, da piu' controller
        Parole parole = new Parole();
        fxmlController.setModel(parole);
        log.trace("iniettato model in fxmlController");

        // definisce la finestra
        primaryStage.setTitle("Elenco Parole");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
