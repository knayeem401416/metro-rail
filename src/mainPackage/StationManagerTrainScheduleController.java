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
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StationManagerTrainScheduleController implements Initializable {

    @FXML
    private DatePicker chooseDate;
    @FXML
    private ComboBox<Integer> trainNumberComboBox;
    @FXML
    private TextField departureTimeTextField;
    @FXML
    private TextField arrivalTimeTextField;
    @FXML
    private TextField seatCapacityTextField;
    @FXML
    private TextField seatAvailableTextField;
    @FXML
    private TableView<TrainSchedule> trainScheduleTableView;
    @FXML
    private TableColumn<TrainSchedule, LocalDate> dateColumn;
    @FXML
    private TableColumn<TrainSchedule, Integer> trainNoColumn;
    @FXML
    private TableColumn<TrainSchedule, String> departureTimeColumn;
    @FXML
    private TableColumn<TrainSchedule, String> arrivalTimeColumn;
    @FXML
    private TableColumn<TrainSchedule, Integer> seatCapacityColumn;
    @FXML
    private TableColumn<TrainSchedule, Integer> seatAvailableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        trainNumberComboBox.getItems().addAll(1,2,3,4,5,6);
        
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        trainNoColumn.setCellValueFactory(new PropertyValueFactory<>("train no"));
        departureTimeColumn.setCellValueFactory(new PropertyValueFactory<>("departure time"));
        arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<>("arrival time"));
        seatCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("seat capacity"));
        seatAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("seat available"));
    }    

    @FXML
    private void saveScheduleOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Train_Schedule.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            String date = chooseDate.getValue().toString(); // Convert LocalDate to String
            dos.writeUTF(date);
            dos.writeInt(trainNumberComboBox.getValue());
            dos.writeUTF(departureTimeTextField.getText());
            dos.writeUTF(arrivalTimeTextField.getText());
            dos.writeUTF(seatCapacityTextField.getText());
            dos.writeUTF(seatAvailableTextField.getText());
            
            chooseDate.setValue(null);
            trainNumberComboBox.getSelectionModel().clearSelection();
            departureTimeTextField.clear();
            arrivalTimeTextField.clear();
            seatCapacityTextField.clear();
            seatAvailableTextField.clear();
            

        } catch (IOException ex) {
            Logger.getLogger(StationManagerTrainScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(StationManagerTrainScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void loadScheduleOnClick(ActionEvent event) {
        trainScheduleTableView.getItems().clear();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("Train_Schedule.bin"))) {
        while (dataInputStream.available() > 0){
            String date = dataInputStream.readUTF();
            LocalDate dateChoose = LocalDate.parse(date);
            Integer trainNumber = dataInputStream.readInt();
            String departureTime = dataInputStream.readUTF();
            String arrivalTime = dataInputStream.readUTF();
            String seatCapacity = dataInputStream.readUTF();
            String seatAvailable = dataInputStream.readUTF();

            // Create an instance of MaintenanceDetails
            TrainSchedule ts = new TrainSchedule(dateChoose, trainNumber, departureTime, arrivalTime, seatCapacity, seatAvailable);
            trainScheduleTableView.getItems().add(ts);
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception appropriately
    }
    }
    
}
