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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class SecurityPersonelCCTVAndActionSceneController implements Initializable {

    @FXML
    private ComboBox<Integer> cctvNoCB;
    @FXML
    private ComboBox<String> crimeTypeCB;
    @FXML
    private TextArea actionDescriptionTextArea;
    @FXML
    private PieChart crimeTypePieChart;
    
    private List<CCTVAndAction> cctvAndActionList = new ArrayList<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cctvNoCB.getItems().addAll(1,2,3,4,5,6,7,8,9);
        crimeTypeCB.getItems().addAll("Theft", "Harassment", "Cyber Security", "Terrorism", "other");
    }    

    @FXML
    private void SaveButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("CCTV_&_Action.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            dos.writeInt(cctvNoCB.getValue());
            dos.writeUTF(crimeTypeCB.getValue());
            dos.writeUTF(actionDescriptionTextArea.getText());
            // Convert LocalDate to String
            String formattedDate = LocalDate.now().toString(); 
            dos.writeUTF(formattedDate);
            
            cctvNoCB.getSelectionModel().clearSelection();
            crimeTypeCB.getSelectionModel().clearSelection();
            actionDescriptionTextArea.clear();
        } 
        
        catch (IOException ex) {
            Logger.getLogger(SecurityPersonelCCTVAndActionSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally {
            try {
                if(dos != null) dos.close();
            } 
            
            catch (IOException ex) {
                Logger.getLogger(SecurityPersonelCCTVAndActionSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        CCTVAndAction cctva = new CCTVAndAction(
            cctvNoCB.getValue(),
            crimeTypeCB.getValue(),
            actionDescriptionTextArea.getText()
        );
        cctvAndActionList.add(cctva);

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
    private void generatePieChartButtonOnClick(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // Read data from the CCTV_&_Action.bin file and count crime types
        Map<String, Integer> crimeTypeCount = new HashMap<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("CCTV_&_Action.bin"))) {
            while (dis.available() > 0) {
                int cctvNo = dis.readInt();
                String crimeType = dis.readUTF();
                String actionDescription = dis.readUTF();
                String date = dis.readUTF();
            
                crimeTypeCount.put(crimeType, crimeTypeCount.getOrDefault(crimeType, 0) + 1);
            }
        } 
        
        catch (IOException ex) {
            Logger.getLogger(SecurityPersonelCCTVAndActionSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Create PieChart.Data objects from the crime type counts
        for (Map.Entry<String, Integer> entry : crimeTypeCount.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        // Set the data for the PieChart
        crimeTypePieChart.setData(pieChartData);
    }
}
