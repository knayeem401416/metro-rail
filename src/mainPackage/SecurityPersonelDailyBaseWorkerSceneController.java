/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nayeem Khan
 */
public class SecurityPersonelDailyBaseWorkerSceneController implements Initializable {

    @FXML
    private BarChart<String, Number> dailyBaseSecurityBarChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private TextField numOfSecurityTextField;
    @FXML
    private DatePicker dateDP;
    
    protected SecurityPersonel s1 = new SecurityPersonel();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void generateBarChartButtonOnClick(ActionEvent event) {
        // Get the data for the chart
        BarChart<String, Number> chartData = s1.viewDailyBaseWorkerBarChart(Integer.parseInt(numOfSecurityTextField.getText()), LocalDate.parse(dateDP.getValue().toString()));

        // Create a new series to hold the data
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Set the name of the series (optional)
        // Add the data to the series
        for (XYChart.Data<String, Number> data : chartData.getData().get(0).getData()) {
            series.getData().add(data);
            series.setName(dateDP.getValue().toString());
        }

        //Clear any existing data from the chart
        //perfoBarChart.getData().clear();
        // Add the series to the chart
        dailyBaseSecurityBarChart.getData().add(series);
    }
    
}
