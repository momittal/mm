/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.PatientAttributes.ERVisitHistory;
import Business.PatientAttributes.PDCVisitHistory;
import Business.PatientAttributes.VitalSignsHistory;
import java.util.Date;

/**
 *
 * @author Mohit
 */
public class Patient extends Employee{
    private String bloodGroup;
    private Date dateOfBirth;
    private int age;
    private String insuranceInfo;
    private VitalSignsHistory vitalSignsHistory;
    private ERVisitHistory erVisitHistory;
    private PDCVisitHistory pdcVisitHistory;
    private PrimaryDoctor primaryDoctor;
    
    public Patient(){
        this.vitalSignsHistory = new VitalSignsHistory();
        this.erVisitHistory = new ERVisitHistory();
        this.pdcVisitHistory = new PDCVisitHistory();
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInsuranceInfo() {
        return insuranceInfo;
    }

    public void setInsuranceInfo(String insuranceInfo) {
        this.insuranceInfo = insuranceInfo;
    }

    public VitalSignsHistory getVitalSignsHistory() {
        return vitalSignsHistory;
    }

    public void setVitalSignsHistory(VitalSignsHistory vitalSignsHistory) {
        this.vitalSignsHistory = vitalSignsHistory;
    }

   

    public ERVisitHistory getErVisitHistory() {
        return erVisitHistory;
    }

    public void setErVisitHistory(ERVisitHistory erVisitHistory) {
        this.erVisitHistory = erVisitHistory;
    }

    public PDCVisitHistory getPdcVisitHistory() {
        return pdcVisitHistory;
    }

    public void setPdcVisitHistory(PDCVisitHistory pdcVisitHistory) {
        this.pdcVisitHistory = pdcVisitHistory;
    }
    
    
    public PrimaryDoctor getPrimaryDoctor() {
        return primaryDoctor;
    }

    public void setPrimaryDoctor(PrimaryDoctor primaryDoctor) {
        this.primaryDoctor = primaryDoctor;
    }
    
    
    
}
