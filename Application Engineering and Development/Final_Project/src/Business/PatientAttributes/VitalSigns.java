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
public class VitalSigns {
    private int vitalSignsID;
    private Date timeStamp;
    private int systolicBloodPressure;
    private int heartRate;
    private int respiratoryRate;
    private double weightInKg;
    private int ecg;
    private boolean status;
    
    public VitalSigns(){
        timeStamp = new Date();
        vitalSignsID = (int)timeStamp.getTime()/(1000);
    }
    
    public int getVitalSignsID() {
        return vitalSignsID;
    }

    

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(int systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public int getEcg() {
        return ecg;
    }

    public void setEcg(int ecg) {
        this.ecg = ecg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    

    @Override
    public String toString() {
        return String.valueOf(timeStamp);
    }

}
