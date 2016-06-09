package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohit
 */
public abstract class Role {
    public enum RoleType{  
        CityAdmin("City Admin"),
        ERAdmin("ER Admin"),
        PDCAdmin("PDC Admin"),
        Patient("Patient"), 
        Volunteer("Volunteer"), 
        EmergencyContact("Emergency Contact"),
        PDCPrimaryDoctor("Primary Doctor"),
        PDCReceptionist("Receptionist"),
        Ambulance("Ambulance"),
        ERCoordinator("ER Coordinator"),
        ERSpecialistDoctorTeam("ER Specialist Doctor Team"),
        ERGeneralDoctorTeam("ER General Doctor Team"),
        PDCNurse("PDC Nurse");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business,
            Network network);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
