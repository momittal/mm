/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PDCNurseRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class PDCNurseOrganization extends Organization {

    public PDCNurseOrganization() {
        super(Organization.Type.PDCNurse.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PDCNurseRole());
        return roles;
    }
}
