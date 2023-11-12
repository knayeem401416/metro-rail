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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class SecurityPersonelContactPoliceStationSceneController implements Initializable {

    @FXML
    private TextField policeStationIdTextField;
    @FXML
    private TextArea describeCrimeTextArea;
    @FXML
    private ComboBox<String> crimeTypeCB;
    @FXML
    private DatePicker dateDP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crimeTypeCB.getItems().addAll("Theft", "Harassment", "Cyber Security", "Terrorism", "other");
    }    


    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SecurityPersonelDashboardScene.fxml"));
        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Contact_Police_Station.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            dos.writeInt(Integer.parseInt(policeStationIdTextField.getText()));
            dos.writeUTF(crimeTypeCB.getValue());
            dos.writeUTF(describeCrimeTextArea.getText());
            // Convert LocalDate to String
            String formattedDate = dateDP.getValue().toString();; 
            dos.writeUTF(formattedDate);
            
            
            policeStationIdTextField.clear();
            crimeTypeCB.getSelectionModel().clearSelection();
            describeCrimeTextArea.clear();
            dateDP.setValue(null);
        } 
        
        catch (IOException ex) {
            Logger.getLogger(SecurityPersonelContactPoliceStationSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally {
            try {
                if(dos != null) dos.close();
            } 
            
            catch (IOException ex) {
                Logger.getLogger(SecurityPersonelContactPoliceStationSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
