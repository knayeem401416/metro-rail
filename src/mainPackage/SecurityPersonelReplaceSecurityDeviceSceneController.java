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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class SecurityPersonelReplaceSecurityDeviceSceneController implements Initializable {

    @FXML
    private ComboBox<String> deviceNameCB;
    @FXML
    private TextField damagedAmountTextField;
    @FXML
    private TableView<SecurityDevice> loadinfoTableView;
    @FXML
    private TableColumn<SecurityDevice, String> nameColumn;
    @FXML
    private TableColumn<SecurityDevice, Integer> damagedAmountColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deviceNameCB.getItems().addAll("CCTV", "X-ray Scanner", "Emergency Alarm",
                "Access Control Gate", "Metal Detector", "Camera");
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        damagedAmountColumn.setCellValueFactory(new PropertyValueFactory<>("damagedAmount"));
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Replace_Security_Device.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            dos.writeUTF(deviceNameCB.getValue());
            dos.writeInt(Integer.parseInt(damagedAmountTextField.getText()));
            
            deviceNameCB.getSelectionModel().clearSelection();  
            damagedAmountTextField.clear();
        } 
        
        catch (IOException ex) {
            Logger.getLogger(SecurityPersonelReplaceSecurityDeviceSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally {
            try {
                if(dos != null) dos.close();
            } 
            
            catch (IOException ex) {
                Logger.getLogger(SecurityPersonelReplaceSecurityDeviceSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void loadInfoButtonOnClick(ActionEvent event) {
        loadinfoTableView.getItems().clear();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Replace_Security_Device.bin"))) {
            while (dataInputStream.available() > 0) {
                String deviceName = dataInputStream.readUTF();
                Integer damagedDeviceAmount = dataInputStream.readInt();
                
                // Create an instance of HelpAndSafety
                SecurityDevice sd = new SecurityDevice(deviceName, damagedDeviceAmount);
                loadinfoTableView.getItems().add(sd);
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
    
}
