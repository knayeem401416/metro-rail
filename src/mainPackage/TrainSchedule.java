/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class TrainSchedule implements Serializable {
    
    private LocalDate chooseDate;
    private Integer trainNumberComboBox;
    private String departureTimeTextField;
    private String arrivalTimeTextField;
    private String seatCapacityTextField;
    private String seatAvailabilityTextField;

    public TrainSchedule(LocalDate chooseDate, Integer trainNumberComboBox, String departureTimeTextField, String arrivalTimeTextField, String seatCapacityTextField, String seatAvailabilityTextField) {
        this.chooseDate = chooseDate;
        this.trainNumberComboBox = trainNumberComboBox;
        this.departureTimeTextField = departureTimeTextField;
        this.arrivalTimeTextField = arrivalTimeTextField;
        this.seatCapacityTextField = seatCapacityTextField;
        this.seatAvailabilityTextField = seatAvailabilityTextField;
    }

    public LocalDate getChooseDate() {
        return chooseDate;
    }

    public void setChooseDate(LocalDate chooseDate) {
        this.chooseDate = chooseDate;
    }

    public Integer getTrainNumberComboBox() {
        return trainNumberComboBox;
    }

    public void setTrainNumberComboBox(Integer trainNumberComboBox) {
        this.trainNumberComboBox = trainNumberComboBox;
    }

    public String getDepartureTimeTextField() {
        return departureTimeTextField;
    }

    public void setDepartureTimeTextField(String departureTimeTextField) {
        this.departureTimeTextField = departureTimeTextField;
    }

    public String getArrivalTimeTextField() {
        return arrivalTimeTextField;
    }

    public void setArrivalTimeTextField(String arrivalTimeTextField) {
        this.arrivalTimeTextField = arrivalTimeTextField;
    }

    public String getSeatCapacityTextField() {
        return seatCapacityTextField;
    }

    public void setSeatCapacityTextField(String seatCapacityTextField) {
        this.seatCapacityTextField = seatCapacityTextField;
    }

    public String getSeatAvailabilityTextField() {
        return seatAvailabilityTextField;
    }

    public void setSeatAvailabilityTextField(String seatAvailabilityTextField) {
        this.seatAvailabilityTextField = seatAvailabilityTextField;
    }
    
    
}
