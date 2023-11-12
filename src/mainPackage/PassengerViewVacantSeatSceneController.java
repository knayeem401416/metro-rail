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
public class PassengerViewVacantSeatSceneController implements Initializable {

    @FXML
    private ComboBox<Integer> trainNoCB;
    @FXML
    private TableView<TrainSchedule> seatTableView;
    @FXML
    private TableColumn<TrainSchedule, Integer> trainNoColumn;
    @FXML
    private TableColumn<TrainSchedule, Integer> seatCapacityColumn;
    @FXML
    private TableColumn<TrainSchedule, Integer> vacantSeatColumn;
    @FXML
    private TableColumn<TrainSchedule, String> departureStationColumn;
    @FXML
    private TableColumn<TrainSchedule, String> arrivalStationColumn;
    @FXML
    private ComboBox<String> departureStationCB;
    @FXML
    private ComboBox<String> arrivalStationCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trainNoCB.getItems().addAll(1,2,3,4,5,6);
        
        trainNoColumn.setCellValueFactory(new PropertyValueFactory<>("trainNo"));
        departureStationColumn.setCellValueFactory(new PropertyValueFactory<>("departureStation"));
        arrivalStationColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalStation"));
        seatCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("seatCapacity"));
        vacantSeatColumn.setCellValueFactory(new PropertyValueFactory<>("vacantSeat"));
    }    

    @FXML
    private void checkSeatButtonOnClick(ActionEvent event) {
        
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
