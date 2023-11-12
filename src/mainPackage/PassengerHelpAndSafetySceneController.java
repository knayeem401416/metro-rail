/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class PassengerHelpAndSafetySceneController implements Initializable {

    @FXML
    private TextField IdTexrField;
    @FXML
    private TextArea describeIssueTextArea;
    @FXML
    private ComboBox<String> issueCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        issueCB.getItems().addAll("Theft", "Harassment", "Cyber Security",
                "Health", "Hygiene", "Terrorism", "Ticket Purchase", "other");
    }    

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerDashboardScene.fxml"));
        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void sendIusseButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Help_&_Safety.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            dos.writeUTF(IdTexrField.getText());
            dos.writeUTF(issueCB.getValue());
            dos.writeUTF(describeIssueTextArea.getText());
            // Convert LocalDate to String
            String formattedDate = LocalDate.now().toString(); 
            dos.writeUTF(formattedDate);
            
            IdTexrField.clear();
            issueCB.getSelectionModel().clearSelection();
            describeIssueTextArea.clear();
        } 
        
        catch (IOException ex) {
            Logger.getLogger(PassengerHelpAndSafetySceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally {
            try {
                if(dos != null) dos.close();
            } 
            
            catch (IOException ex) {
                Logger.getLogger(PassengerHelpAndSafetySceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
