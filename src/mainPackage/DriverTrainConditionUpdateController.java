/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DriverTrainConditionUpdateController implements Initializable {

    @FXML
    private RadioButton lightOkay;
    @FXML
    private RadioButton lightNotOkay;
    @FXML
    private RadioButton engineOkay;
    @FXML
    private RadioButton engineNotOkay;
    @FXML
    private RadioButton acOkay;
    @FXML
    private RadioButton acNotOkay;
    @FXML
    private RadioButton gateOkay;
    @FXML
    private RadioButton gateNotOkay;
    @FXML
    private RadioButton fireOkay;
    @FXML
    private RadioButton fireNotOkay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void previousButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void updateConditionButtonOnClick(ActionEvent event) {
    }
    
}
