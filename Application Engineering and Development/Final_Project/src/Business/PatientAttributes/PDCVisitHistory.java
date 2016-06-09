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
public class PDCVisitHistory {
    private ArrayList<PDCVisit> pdcVisitHistory;
    
    public PDCVisitHistory(){
        this.pdcVisitHistory = new ArrayList<>();
    }

    public ArrayList<PDCVisit> getPdcVisitHistory() {
        return pdcVisitHistory;
    }

    public void setPdcVisitHistory(ArrayList<PDCVisit> pdcVisitHistory) {
        this.pdcVisitHistory = pdcVisitHistory;
    }
    
    
    
    
    public PDCVisit addPDCVisit() {
        PDCVisit pdcVisit = new PDCVisit();
        pdcVisitHistory.add(pdcVisit);
        return pdcVisit;
    }
    
    public void deleteVitalSigns(VitalSigns pdcVisit) {
        pdcVisitHistory.remove(pdcVisit);
    }
}
