/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class SecurityPersonelEmergencyResponseSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextArea describeResponseTextArea;
    @FXML
    private TableView<HelpAndSafety> helpAndSafetyTableView;
    @FXML
    private TableColumn<HelpAndSafety, Integer> idColumn;
    @FXML
    private TableColumn<HelpAndSafety, String> issueColumn;
    @FXML
    private TableColumn<HelpAndSafety, String> describeIssueColumn;
    @FXML
    private TableColumn<HelpAndSafety, String> dateColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        issueColumn.setCellValueFactory(new PropertyValueFactory<>("issue"));
        describeIssueColumn.setCellValueFactory(new PropertyValueFactory<>("describeIssue"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }    

    @FXML
    private void loadHelpAndSafetyButtonOnClick(ActionEvent event) {
        helpAndSafetyTableView.getItems().clear();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Help_&_Safety.bin"))) {
            while (dataInputStream.available() > 0) {
                Integer id = dataInputStream.readInt();
                String issue = dataInputStream.readUTF();
                String describeIssue = dataInputStream.readUTF();
                String dateString = dataInputStream.readUTF();
                // Convert String to LocalDate
                LocalDate date = LocalDate.parse(dateString); 
                // Create an instance of HelpAndSafety
                HelpAndSafety hs = new HelpAndSafety(id, issue, describeIssue, date);
                helpAndSafetyTableView.getItems().add(hs);
            }
        } 
        catch (IOException e) {
        e.printStackTrace();
        // Handle the exception appropriately
        }
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
    private void saveButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Emergency_Response.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            dos.writeUTF(idTextField.getText());
            dos.writeUTF(describeResponseTextArea.getText());
            // Convert LocalDate to String
            String formattedDate = LocalDate.now().toString(); 
            dos.writeUTF(formattedDate);
            
            idTextField.clear();
            describeResponseTextArea.clear();
        } 
        
        catch (IOException ex) {
            Logger.getLogger(SecurityPersonelEmergencyResponseSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally {
            try {
                if(dos != null) dos.close();
            } 
            
            catch (IOException ex) {
                Logger.getLogger(SecurityPersonelEmergencyResponseSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
