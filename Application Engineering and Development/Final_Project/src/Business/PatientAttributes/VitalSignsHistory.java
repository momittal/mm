/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientAttributes;

import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class VitalSignsHistory {
    private ArrayList<VitalSigns> vitalSignsHistory;
    
    public VitalSignsHistory(){
        this.vitalSignsHistory = new ArrayList<>();
    }

    public ArrayList<VitalSigns> getVitalSignsHistory() {
        return vitalSignsHistory;
    }

    public void setVitalSignsHistory(ArrayList<VitalSigns> vitalSignsHistory) {
        this.vitalSignsHistory = vitalSignsHistory;
    }
    
    public VitalSigns addVitalSigns() {
        VitalSigns vs = new VitalSigns();
        vitalSignsHistory.add(vs);
        return vs;
    }
    
    public void deleteVitalSigns(VitalSigns vs) {
        vitalSignsHistory.remove(vs);
    }
    
}
