/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

/**
 *
 * @author Nayeem Khan
 */
public class EmergencyDetails {
    private int id;
    private String describeResponse;

    public EmergencyDetails(int id, String describeResponse) {
        this.id = id;
        this.describeResponse = describeResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribeResponse() {
        return describeResponse;
    }

    public void setDescribeResponse(String describeResponse) {
        this.describeResponse = describeResponse;
    }
    
    
}
