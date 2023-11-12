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
class SecurityDevice {
    private String deviceName;
    private int damagedDeviceAmountName;

    public SecurityDevice(String deviceName, int damagedDeviceAmountName) {
        this.deviceName = deviceName;
        this.damagedDeviceAmountName = damagedDeviceAmountName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDamagedDeviceAmountName() {
        return damagedDeviceAmountName;
    }

    public void setDamagedDeviceAmountName(int damagedDeviceAmountName) {
        this.damagedDeviceAmountName = damagedDeviceAmountName;
    }
    
    
}
