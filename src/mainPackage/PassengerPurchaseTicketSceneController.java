/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class PassengerPurchaseTicketSceneController implements Initializable {

    @FXML
    private ComboBox<Integer> ticketAmountCB;
    @FXML
    private DatePicker dateOfJourneyDatePicker;
    @FXML
    private ComboBox<String> departureStationCB;
    @FXML
    private ComboBox<String> arrivalStationCB;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private TextArea purchaseTicketInfoTextArea;
    @FXML
    private ComboBox<String> paymentMethodCB;
    @FXML
    private TextField paymentAmountTextField;
    @FXML
    private TextField departureTimeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ticketAmountCB.getItems().addAll(1,2,3,4);
    }    

    @FXML
    private void purchaseTicketButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void paymentButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerDashboardScene.fxml"));
        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }
    
}
