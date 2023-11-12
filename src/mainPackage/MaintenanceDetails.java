/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class MaintenanceDetails {
    private String problemName;
    private String details;
    private String stationName;
    private Integer trainNumber;
    private LocalDate deadline;

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public MaintenanceDetails(String problemName, String details, String stationName, Integer trainNumber, LocalDate deadline) {
        this.problemName = problemName;
        this.details = details;
        this.stationName = stationName;
        this.trainNumber = trainNumber;
        this.deadline = deadline;
    }
}
