/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.LocalDate;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author User
 */
public class StationManager extends User{
    
    public BarChart<String, Number> viewMonthlyProfitChart(String month, Number amount) {

        CategoryAxis monthAxis = new CategoryAxis();
        NumberAxis profitAxis = new NumberAxis();
        BarChart<String, Number> chart = new BarChart<>(monthAxis, profitAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.getData().add(new XYChart.Data<String, Number>(month, amount));
        chart.getData().add(series);
        return chart;

    }
}

