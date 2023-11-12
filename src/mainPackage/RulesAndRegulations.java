/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

/**
 *
 * @author Nayeem Khan
 */
public class RulesAndRegulations {
    private String userType;
    private String rulesAndRegulations;

    public RulesAndRegulations(String userType, String rulesAndRegulations) {
        this.userType = userType;
        this.rulesAndRegulations = rulesAndRegulations;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRulesAndRegulations() {
        return rulesAndRegulations;
    }

    public void setRulesAndRegulations(String rulesAndRegulations) {
        this.rulesAndRegulations = rulesAndRegulations;
    }
    
    
}
