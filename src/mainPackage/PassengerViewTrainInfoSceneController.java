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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class PassengerViewTrainInfoSceneController implements Initializable {

    @FXML
    private TableView<TrainSchedule> trainInfoTableView;
    @FXML
    private TableColumn<TrainSchedule, Integer> trainNoColumn;
    @FXML
    private TableColumn<TrainSchedule, String> dateColumn;
    @FXML
    private TableColumn<TrainSchedule, String> departureStationColumn;
    @FXML
    private TableColumn<TrainSchedule, String> arrivalStationColumn;
    @FXML
    private TableColumn<TrainSchedule, String> departureTimeColumn;
    @FXML
    private TableColumn<TrainSchedule, String> arrivalTimeColumn;
    @FXML
    private ComboBox<String> departureStationCB;
    @FXML
    private ComboBox<String> arrivalStationCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trainNoColumn.setCellValueFactory(new PropertyValueFactory<>("trainNo"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        departureStationColumn.setCellValueFactory(new PropertyValueFactory<>("departureStation"));
        arrivalStationColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalStation"));
        departureTimeColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
    }    

    @FXML
    private void searchTrainButtonOnClick(ActionEvent event) {
        
    }

    @FXML
    private void returnHomeButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PassengerDashboardScene.fxml"));
        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }
    
}
