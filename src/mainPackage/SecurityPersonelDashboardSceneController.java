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
public class SecurityPersonelDashboardSceneController implements Initializable {

    @FXML
    private BorderPane securityPersonelDashboardBorderPane;
    @FXML
    private Label securityIdLabel;
    @FXML
    private TextArea securityTermsAndConditionsTextArea;
    @FXML
    private TextArea securityNoticeTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        securityIdLabel.setText("Logged in as 2120.");
        securityTermsAndConditionsTextArea.setText("No Terms & Conditions to view.");
        securityNoticeTextArea.setText("No notice to view.");
    }    

    @FXML
    private void securityViewCCTVAndActionButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelCCTVAndActionScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void securityRulesAndRegulationsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelRulesAndRegulationsScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void securityEmergencyResponseButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelEmergencyResponseScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void securityContactPoliceStationButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelContactPoliceStationScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void securityVerifyVisitorButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelVerifyVisitorScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void securityViewContactHistoryButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelViewContactPoliceStationHistoryScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void securityViewDailyBaseWorkerButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelDailyBaseWorkerScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void securityReplaceSecurityDeviceButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelReplaceSecurityDeviceScene.fxml"));
        securityPersonelDashboardBorderPane.setCenter(parent);
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
