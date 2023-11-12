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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField idTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeComboBox.getItems().addAll(
                "Passenger", "Security Personnel", "Ticket Inspector", "Maintenance Officer",
                "Project Director", "Accounts Manager", "Driver", "Station Manager"
        );
    }    

    @FXML
    private void logInButtonOnClick(ActionEvent event) throws IOException {
        int userId;
        String pass_str;
        userId = Integer.parseInt(idTextField.getText());
        pass_str = passwordTextField.getText();
        if ((userId == 2120757) && pass_str.equals("123") && userTypeComboBox.getValue().equals("Station Manager")) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Welcome " + userId);
            a1.showAndWait();

            Parent parent = FXMLLoader.load(getClass().getResource("StationManagerDashboardScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        } 
        else if ((userId == 21207) && pass_str.equals("123") && userTypeComboBox.getValue().equals("Passenger")) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Welcome " + userId);
            a1.showAndWait();

            Parent parent = FXMLLoader.load(getClass().getResource("PassengerDashboardScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        } 
        else if ((userId == 2120757) && pass_str.equals("123") && userTypeComboBox.getValue().equals("Driver")) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Welcome " + userId);
            a1.showAndWait();

            Parent parent = FXMLLoader.load(getClass().getResource("DriverDashboardScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        } 
        else if ((userId == 3015) && pass_str.equals("123") && userTypeComboBox.getValue().equals("Ticket Inspector")) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Welcome " + userId);
            a1.showAndWait();

            Parent parent = FXMLLoader.load(getClass().getResource("TicketInspectorDashboardScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        } 
        else if ((userId == 2120) && pass_str.equals("123") && userTypeComboBox.getValue().equals("Security Personnel")) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Welcome " + userId);
            a1.showAndWait();

            Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelDashboardScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        } 
        else if ((userId == 2112) && pass_str.equals("123") && userTypeComboBox.getValue().equals("Maintenance Officer")) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION);
            a1.setTitle("LogIn Status");
            a1.setContentText("Click Ok to Continue");
            a1.setHeaderText("Welcome " + userId);
            a1.showAndWait();

            Parent parent = FXMLLoader.load(getClass().getResource("MaintenanceOfficerDashboard.fxml"));
            Scene scene = new Scene(parent);
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        } 
        else {
            Alert a2 = new Alert(Alert.AlertType.WARNING);
            a2.setTitle("Warning ");
            a2.setHeaderText("LogIn Failed");
//            a2.setContentText("Wrong ID/Password");
            a2.setContentText("Wrong ID/Password. Please Try Again");
            a2.showAndWait();
        }
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) {
    }
    
}
