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
public class ERVisitHistory {
    private ArrayList<ERVisit> erVisitHistory;
    
    public ERVisitHistory(){
        this.erVisitHistory = new ArrayList<>();
    }

    public ArrayList<ERVisit> getErVisitHistory() {
        return erVisitHistory;
    }

    public void setErVisitHistory(ArrayList<ERVisit> erVisitHistory) {
        this.erVisitHistory = erVisitHistory;
    }
    
    
    
    
    public ERVisit addERVisit() {
        ERVisit erVisit = new ERVisit();
        erVisitHistory.add(erVisit);
        return erVisit;
    }
    
    public void deleteVitalSigns(VitalSigns erVisit) {
        erVisitHistory.remove(erVisit);
    }
}
