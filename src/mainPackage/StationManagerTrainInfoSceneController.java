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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StationManagerTrainInfoSceneController implements Initializable {

    @FXML
    private ComboBox<Integer> selectTrainNumberCombo;
    @FXML
    private TableView<TrainInformation> trainConditionTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectTrainNumberCombo.getItems().addAll(1,2,3,4,5,6);
        
    }    

    @FXML
    private void seeTrainConditionButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void previousSceneOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StationManagerDashboardScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(scene);
        stg.show();
    }
    
}
