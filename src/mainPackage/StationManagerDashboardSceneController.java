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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StationManagerDashboardSceneController implements Initializable {

    @FXML
    private TextArea nameTextArea;
    @FXML
    private TextArea idTextArea;
    @FXML
    private TextArea dobTextArea;
    @FXML
    private TextArea nidTextArea;
    @FXML
    private TextArea emailTextArea;
    @FXML
    private TextArea numberTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameTextArea.setText("Fahim Ahmed");
        idTextArea.setText("2120757");
        dobTextArea.setText("23/01/2000");
        nidTextArea.setText("1875697823659");
        emailTextArea.setText("2120757@iub.edu.bd");
        numberTextArea.setText("01894749253");
        
    }    

    @FXML
    private void trainInfoButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerTrainInfoScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void trainScheduleButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerTrainSchedule.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void stationAnalyticsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerStationAnalyticsScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void sendNoticeButtonOnCLick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerSendNoticeScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void checkFeedBackButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerCheckFeedBackScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void maintenanceButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerMaintenanceIssueScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void generateReportButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationMangerGenerateReportScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void sendMessageButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerMessegeScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void logOutButtonClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
        
    }
    
}
