/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class PrimaryDoctor extends Employee{
    private ArrayList<Patient> primaryDoctorsPatientList;
    
    public PrimaryDoctor(){
        primaryDoctorsPatientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPrimaryDoctorsPatientList() {
        return primaryDoctorsPatientList;
    }

    public void setPrimaryDoctorsPatientList(ArrayList<Patient> primaryDoctorsPatientList) {
        this.primaryDoctorsPatientList = primaryDoctorsPatientList;
    }
    
    
    
}
