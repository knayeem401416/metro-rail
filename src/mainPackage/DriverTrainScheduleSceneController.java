/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DriverTrainScheduleSceneController implements Initializable {

    @FXML
    private TableView<?> viewTrainScheduleTable;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> trainNumberColumn;
    @FXML
    private TableColumn<?, ?> departureTimeColumn;
    @FXML
    private TableColumn<?, ?> arrivalTimeColumn;
    @FXML
    private TableColumn<?, ?> seatCapacityColumn;
    @FXML
    private TableColumn<?, ?> seatAvailabilityColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadTrainScheduleOnClick(ActionEvent event) {
    }

    @FXML
    private void previousSceneOnClick(ActionEvent event) {
    }
    
}
