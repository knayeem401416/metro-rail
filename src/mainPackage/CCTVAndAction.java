/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

/**
 *
 * @author Nayeem Khan
 */
class CCTVAndAction {
    private int cctvNo;
    private String crimeType;
    private String describeAction;


    public CCTVAndAction(int cctvNo, String crimeType, String describeAction) {
        this.cctvNo = cctvNo;
        this.crimeType = crimeType;
        this.describeAction = describeAction;
    }

    public int getCctvNo() {
        return cctvNo;
    }

    public void setCctvNo(int cctvNo) {
        this.cctvNo = cctvNo;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public String getDescribeAction() {
        return describeAction;
    }

    public void setDescribeAction(String describeAction) {
        this.describeAction = describeAction;
    }
    
    
    
}
