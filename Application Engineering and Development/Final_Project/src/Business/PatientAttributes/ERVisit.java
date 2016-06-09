/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientAttributes;

import Business.Employee.Employee;
import java.util.Date;

/**
 *
 * @author Mohit
 */
public class ERVisit {
    private Date timeStamp;
    private boolean aspirinTaken;
    private boolean advancedTestsPerformed;
    private boolean statusNormalInAmbulance;
    private boolean isOperatedBySpecialistTeam;
    private boolean isOperatedBygeneralTeam;
    private Employee operatedBy;
    private String erDoctorFeedback;
    //tasks in ER

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isAspirinTaken() {
        return aspirinTaken;
    }

    public void setAspirinTaken(boolean aspirinTaken) {
        this.aspirinTaken = aspirinTaken;
    }

    public boolean isAdvancedTestsPerformed() {
        return advancedTestsPerformed;
    }

    public void setAdvancedTestsPerformed(boolean advancedTestsPerformed) {
        this.advancedTestsPerformed = advancedTestsPerformed;
    }

    public boolean isStatusNormalInAmbulance() {
        return statusNormalInAmbulance;
    }

    public void setStatusNormalInAmbulance(boolean statusNormalInAmbulance) {
        this.statusNormalInAmbulance = statusNormalInAmbulance;
    }

    public boolean isIsOperatedBySpecialistTeam() {
        return isOperatedBySpecialistTeam;
    }

    public void setIsOperatedBySpecialistTeam(boolean isOperatedBySpecialistTeam) {
        this.isOperatedBySpecialistTeam = isOperatedBySpecialistTeam;
    }

    public boolean isIsOperatedBygeneralTeam() {
        return isOperatedBygeneralTeam;
    }

    public void setIsOperatedBygeneralTeam(boolean isOperatedBygeneralTeam) {
        this.isOperatedBygeneralTeam = isOperatedBygeneralTeam;
    }

    public Employee getOperatedBy() {
        return operatedBy;
    }

    public void setOperatedBy(Employee operatedBy) {
        this.operatedBy = operatedBy;
    }

    public String getERDoctorFeedback() {
        return erDoctorFeedback;
    }

    public void setERDoctorFeedback(String ERDoctorFeedback) {
        this.erDoctorFeedback = ERDoctorFeedback;
    }
    
    
    
    @Override
    public String toString() {
        return String.valueOf(timeStamp);
    }
    
}
