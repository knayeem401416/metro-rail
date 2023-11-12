/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class SecurityPersonelViewContactPoliceStationHistorySceneController implements Initializable {

    @FXML
    private TableView<PoliceStation> contactHistoryTableView;
    @FXML
    private TableColumn<PoliceStation, Integer> policeStationIdColumn;
    @FXML
    private TableColumn<PoliceStation, String> crimeTypeColumn;
    @FXML
    private TableColumn<PoliceStation, String> describeCrimeColumn;
    @FXML
    private TableColumn<PoliceStation, String> dateColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        policeStationIdColumn.setCellValueFactory(new PropertyValueFactory<>("policeStationId"));
        crimeTypeColumn.setCellValueFactory(new PropertyValueFactory<>("crimeType"));
        describeCrimeColumn.setCellValueFactory(new PropertyValueFactory<>("describeCrime"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }    

    @FXML
    private void contactHistoryButtonOnClick(ActionEvent event) {
        contactHistoryTableView.getItems().clear();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Contact_Police_Station.bin"))) {
            while (dataInputStream.available() > 0) {
                Integer policeStationId = dataInputStream.readInt();
                String crimeType = dataInputStream.readUTF();
                String describeCrime = dataInputStream.readUTF();
                String dateString = dataInputStream.readUTF();
                // Convert String to LocalDate
                LocalDate date = LocalDate.parse(dateString); 
                // Create an instance of HelpAndSafety
                PoliceStation ps = new PoliceStation(policeStationId, crimeType, describeCrime, date);
                contactHistoryTableView.getItems().add(ps);
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
