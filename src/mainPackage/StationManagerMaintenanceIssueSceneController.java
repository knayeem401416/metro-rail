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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StationManagerMaintenanceIssueSceneController implements Initializable {

    @FXML
    private Button previousSceneOnClick;
    @FXML
    private TextField problemNameTextField;
    @FXML
    private TextField detailstextField;
    @FXML
    private ComboBox<String> stationNameCombo;
    @FXML
    private ComboBox<Integer> trainNumberCombo;
    @FXML
    private DatePicker deadlinedate;
    @FXML
    private Button sendFileOnclick;
    @FXML
    private Button loadFileOnClick;
    @FXML
    private TableView<MaintenanceDetails> maintenanceIssuetableView;
    @FXML
    private TableColumn<MaintenanceDetails, String> prblemNameColumn;
    @FXML
    private TableColumn<MaintenanceDetails, String> detailsColumn;
    @FXML
    private TableColumn<MaintenanceDetails, String> stationNameColumn;
    @FXML
    private TableColumn<MaintenanceDetails, Integer> trainNumberColumn;
    @FXML
    private TableColumn<MaintenanceDetails, String> deadlineColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stationNameCombo.getItems().addAll("Agargaon", "Kajipara", "Shewrapara",
                "Mirpur 10", "Mirpur 11", "Pallabi", "Uttara South", "Uttara North");
        
        trainNumberCombo.getItems().addAll(1,2,3,4,5,6);
        
        prblemNameColumn.setCellValueFactory(new PropertyValueFactory<>("problemName"));
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        stationNameColumn.setCellValueFactory(new PropertyValueFactory<>("stationName"));
        trainNumberColumn.setCellValueFactory(new PropertyValueFactory<>("trainNumber"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

    }    

    @FXML
    private void previousSceneOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerDashboardScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void sendFileOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Maintenance_Details.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            dos.writeUTF(problemNameTextField.getText());
            dos.writeUTF(detailstextField.getText());
            dos.writeUTF(stationNameCombo.getValue());
            dos.writeInt(trainNumberCombo.getValue());
            String formattedDeadline = deadlinedate.getValue().toString(); // Convert LocalDate to String
            dos.writeUTF(formattedDeadline);
            
            problemNameTextField.clear();
            detailstextField.clear();
            stationNameCombo.getSelectionModel().clearSelection();
            trainNumberCombo.getSelectionModel().clearSelection();
            deadlinedate.setValue(null);

        } catch (IOException ex) {
            Logger.getLogger(StationManagerMaintenanceIssueSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(StationManagerMaintenanceIssueSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void loadFileOnClick(ActionEvent event) {
        maintenanceIssuetableView.getItems().clear();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Maintenance_Details.bin"))) {
        while (dataInputStream.available() > 0){
            String problemName = dataInputStream.readUTF();
            String details = dataInputStream.readUTF();
            String stationName = dataInputStream.readUTF();
            Integer trainNumber = dataInputStream.readInt();
            String deadlineString = dataInputStream.readUTF();
            LocalDate deadline = LocalDate.parse(deadlineString); // Convert String to LocalDate

            // Create an instance of MaintenanceDetails
            MaintenanceDetails md = new MaintenanceDetails(problemName, details, stationName, trainNumber, deadline);
            maintenanceIssuetableView.getItems().add(md);
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception appropriately
    }
        
    }
    
}
