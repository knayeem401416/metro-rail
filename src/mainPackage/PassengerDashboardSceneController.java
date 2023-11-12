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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class PassengerDashboardSceneController implements Initializable {

    @FXML
    private Label passIdLabel;
    @FXML
    private TextArea passTermsAndConditionsTextArea;
    @FXML
    private BorderPane passengerDashboardBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        passIdLabel.setText("Logged in as 21207.");
        passTermsAndConditionsTextArea.setText("No Terms & Conditions to view.");
    }    

    @FXML
    private void passViewTrainInfoButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerViewTrainInfoScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void passCheckVacantSeatButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerViewVacantSeatScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void passPurchaseTicketButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerPurchaseTicketScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void passVerifyTicketButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerTicketVerifyScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void passViewPurchasingHistoryButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerTicketHistoryScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void passMonthlyRapidCardButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerMonthlyRapidCardScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void passHelpAndSafetyButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerHelpAndSafetyScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void passSendFeedbackButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerSendFeedbackScene.fxml"));
        passengerDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }
    
}
