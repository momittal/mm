/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mohit
 */
public abstract class Organization {
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private Date timeStamp;
    
    public enum Type{
        CityAdmin("City Admin Organization"),
        ERAdmin("ER Admin Organization"),
        PDCAdmin("PDC Admin Organization"),
        Patient("Patient Organization"), 
        Volunteer("Volunteer Organization"), 
        EmergencyContact("Emergency Contact Organization"),
        PDCPrimaryDoctor("PDC Primary Doctor Organization"),
        PDCReceptionist("PDC Receptionist Organization"),
        PDCNurse("PDC Nurse Organization"),
        Ambulance("Ambulance Organization"),
        ERCoordinator("ER Coordinator Organization"),
        ERGeneralDoctorTeam("ER General Doctor Team Organization"),
        ERSpecialistDoctorTeam("ER Specialist Doctor Team Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        timeStamp = new Date();
        organizationID = abs((int)timeStamp.getTime()/(1000));
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
