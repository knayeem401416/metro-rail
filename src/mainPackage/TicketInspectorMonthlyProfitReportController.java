/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TicketInspectorMonthlyProfitReportController implements Initializable {

    @FXML
    private ComboBox<String> monthSelectCombo;
    @FXML
    private TextField profitAmountTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        monthSelectCombo.getItems().addAll("Jan", "Feb", "March", "April", "May",
                "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec");
    }    

    @FXML
    private void appendFileButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("Monthly_Profit.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);           

            dos = new DataOutputStream(fos);
            
            dos.writeUTF(monthSelectCombo.getValue());
            dos.writeUTF(profitAmountTextField.getText());

        } catch (IOException ex) {
            Logger.getLogger(TicketInspectorMonthlyProfitReportController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (IOException ex) {
                Logger.getLogger(TicketInspectorMonthlyProfitReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
