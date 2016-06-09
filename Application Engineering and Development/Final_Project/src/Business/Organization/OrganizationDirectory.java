/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }
    
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Volunteer.getValue())){
            organization = new VolunteerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PDCPrimaryDoctor.getValue())){
            organization = new PDCPrimaryDoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PDCReceptionist.getValue())){
            organization = new PDCReceptionistOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Ambulance.getValue())){
            organization = new AmbulanceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ERCoordinator.getValue())){
            organization = new ERCoordinatorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ERGeneralDoctorTeam.getValue())){
            organization = new ERGeneralDoctorTeamOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ERSpecialistDoctorTeam.getValue())){
            organization = new ERSpecialistDoctorTeamOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PDCNurse.getValue())){
            organization = new PDCNurseOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    
}
