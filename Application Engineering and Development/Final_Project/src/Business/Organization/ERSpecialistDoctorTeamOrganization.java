/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ERSpecialistDoctorTeamRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class ERSpecialistDoctorTeamOrganization extends Organization {

    public ERSpecialistDoctorTeamOrganization() {
        super(Organization.Type.ERSpecialistDoctorTeam.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ERSpecialistDoctorTeamRole());
        return roles;
    }
    
}
