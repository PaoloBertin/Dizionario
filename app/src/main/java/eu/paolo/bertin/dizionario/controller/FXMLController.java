package eu.paolo.bertin.dizionario.controller;

import java.net.URL;
import java.util.ResourceBundle;

import eu.paolo.bertin.dizionario.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

public class FXMLController implements Initializable {

    private static final Logger log = Logger.getLogger(FXMLController.class.getName());

    private Parole parole;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtElenco;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtPerformance;

    @FXML
    public void inserisci(ActionEvent event) {

        double start = System.nanoTime();
        parole.addParola(txtParola.getText());
        double stop = System.nanoTime();
        txtElenco.setText("");
        for (String parola : parole.getElenco()) {
            txtElenco.appendText(parola + "\n");
        }

        // txtPerformance.clear();
        txtPerformance.appendText("[INSERT]: " + (stop - start) / 1e9 + " seconds" + "\n");
    }

    @FXML
    public void doReset(ActionEvent event) {

        parole.reset();
        txtElenco.clear();
        txtPerformance.clear();
    }

    @FXML
    public void doCancel(ActionEvent event) {

        String word = txtElenco.getSelectedText();

        double start = System.nanoTime();
        parole.removeWord(word);
        double stop = System.nanoTime();

        txtElenco.clear();
        for (String parola : parole.getElenco()) {
            txtElenco.appendText(parola + "\n");
        }

        // txtPerformance.clear();
        txtPerformance.appendText("[REMOVE]: " + (stop - start) / 1e9 + " seconds" + "\n");
    }

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtElenco != null : "fx:id=\"txtElenco\" was not injected: check your FXML file 'scene.fxml'.";
        assert txtPerformance != null : "fx:id=\"txtPerformance\" was not injected: check your FXML file 'scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'scene.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'scene.fxml'.";

    }

    public void setModel(Parole parole) {

        this.parole = parole;
    }
}
