/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientAttributes;

import java.util.Date;

/**
 *
 * @author Mohit
 */
public class PDCVisit {
    private Date timeStamp;
    private String primaryDoctorfeedback;
    
    public PDCVisit(){
        this.timeStamp = new Date();
    }
    
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPrimaryDoctorfeedback() {
        return primaryDoctorfeedback;
    }

    public void setPrimaryDoctorfeedback(String primaryDoctorfeedback) {
        this.primaryDoctorfeedback = primaryDoctorfeedback;
    }

    @Override
    public String toString() {
        return String.valueOf(timeStamp);
    }
    
    
}
