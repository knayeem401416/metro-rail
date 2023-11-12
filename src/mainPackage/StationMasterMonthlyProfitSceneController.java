/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StationMasterMonthlyProfitSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectMonthCombo;
    @FXML
    private TextField profitTextfield;
    @FXML
    private BarChart<String, Number> profitChartView;
    @FXML
    private NumberAxis profitAxis;
    @FXML
    private CategoryAxis monthAxis;
    
    StationManager sm = new StationManager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectMonthCombo.getItems().addAll("Jan", "Feb", "March", "April",
                "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec");
    }    

    @FXML
    private void loadChartOnClick(ActionEvent event) {
        BarChart<String, Number> chartData = sm.viewMonthlyProfitChart(selectMonthCombo.getValue(), Integer.parseInt(profitTextfield.getText()));

        // Create a new series to hold the data
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Set the name of the series (optional)
        // Add the data to the series
        for (XYChart.Data<String, Number> data : chartData.getData().get(0).getData()) {
            series.getData().add(data);
        }

        //Clear any existing data from the chart
        //perfoBarChart.getData().clear();
        // Add the series to the chart
        profitChartView.getData().add(series);
    }
        
    }
    

