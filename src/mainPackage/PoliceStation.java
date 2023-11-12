/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.time.LocalDate;

/**
 *
 * @author Nayeem Khan
 */
class PoliceStation {
    private int policeStationId;
    private String crimeType;
    private String describeCrime;
    private LocalDate date;

    public PoliceStation(int policeStationId, String crimeType, String describeCrime, LocalDate date) {
        this.policeStationId = policeStationId;
        this.crimeType = crimeType;
        this.describeCrime = describeCrime;
        this.date = date;
    }

    public int getPoliceStationId() {
        return policeStationId;
    }

    public void setPoliceStationId(int policeStationId) {
        this.policeStationId = policeStationId;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getDescribeCrime() {
        return describeCrime;
    }

    public void setDescribeCrime(String describeCrime) {
        this.describeCrime = describeCrime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
    
}
