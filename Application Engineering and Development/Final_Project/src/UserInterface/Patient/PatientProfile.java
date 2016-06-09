/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Patient;

import Business.Employee.Employee;
import Business.Employee.Patient;
import Business.Employee.PrimaryDoctor;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PrimaryDoctorsClinicEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PDCPrimaryDoctorOrganization;
import Business.Utils.MyIntegerVerifier;
import Business.Utils.MyStringVerifier;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Mohit
 */
public class PatientProfile extends javax.swing.JPanel {

    private Patient patient;
    private JPanel userProcessContainer;
    private Network network;
    private PrimaryDoctorsClinicEnterprise pdcEnterprise;
    private PatientWorkAreaJPanel pwajp;

    /**
     * Creates new form PatientProfile
     */
    public PatientProfile(JPanel userProcessContainer, Patient patient, Network network, PatientWorkAreaJPanel pwajp) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patient = patient;
        this.network = network;
        this.pwajp = pwajp;
        populateTxtFields();
        MyIntegerVerifier myIntegerVerifier = new MyIntegerVerifier();
        MyStringVerifier myStringVerifier = new MyStringVerifier();
        patientNameTxtField.setInputVerifier(myStringVerifier);
        patientAgeTxtField.setInputVerifier(myIntegerVerifier);
        patientLocationTxtField.setInputVerifier(myIntegerVerifier);
        patientIDTxtField.setInputVerifier(myIntegerVerifier);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        patientNameTxtField = new javax.swing.JTextField();
        patientAgeTxtField = new javax.swing.JTextField();
        patientIDTxtField = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        patientLocationTxtField = new javax.swing.JTextField();
        primaryDoctorComboBox = new javax.swing.JComboBox();
        patientBloodGroupComboBox = new javax.swing.JComboBox();
        patientInsuranceComboBox = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Profile");

        jLabel2.setText("Name");

        jLabel3.setText("Age");

        jLabel4.setText("ID");

        jLabel5.setText("Blood Group");

        jLabel6.setText("Insurance");

        jLabel7.setText("Primary Doctor");

        patientNameTxtField.setEditable(false);

        patientAgeTxtField.setEditable(false);

        patientIDTxtField.setEditable(false);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.setEnabled(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Location");

        patientLocationTxtField.setEditable(false);

        primaryDoctorComboBox.setEnabled(false);
        primaryDoctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primaryDoctorComboBoxActionPerformed(evt);
            }
        });

        patientBloodGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        patientBloodGroupComboBox.setEnabled(false);

        patientInsuranceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        patientInsuranceComboBox.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(108, 108, 108)
                        .addComponent(saveBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(patientLocationTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientAgeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(primaryDoctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientInsuranceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(patientBloodGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(updateBtn))))
                .addGap(386, 386, 386))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(updateBtn))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(patientNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(patientAgeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(patientIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(patientBloodGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(patientInsuranceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(primaryDoctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(patientLocationTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(saveBtn))
                .addGap(202, 202, 202))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        updateBtn.setEnabled(false);
        saveBtn.setEnabled(true);
        
        patientLocationTxtField.setEditable(true);
        patientNameTxtField.setEditable(true);
        patientAgeTxtField.setEditable(true);
        if (patient.getPrimaryDoctor() == null) {
            primaryDoctorComboBox.setEnabled(true);
            populateComboBox();
        }
        
        populateInsuranceAndBloodGroupComboBox();
        patientBloodGroupComboBox.setEnabled(true);
        patientInsuranceComboBox.setEnabled(true);
        
    }//GEN-LAST:event_updateBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        if(patientNameTxtField.getText().trim().length()==0 || patientLocationTxtField.getText().trim().length()==0 || patientAgeTxtField.getText().trim().length()==0)
        {
            JOptionPane.showMessageDialog(this, "Please enter all values","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        patient.setBloodGroup(String.valueOf(patientBloodGroupComboBox.getSelectedItem()));
        patient.setInsuranceInfo(String.valueOf(patientInsuranceComboBox.getSelectedItem()));
        patient.setLocation(Integer.parseInt(patientLocationTxtField.getText()));
        patient.setName(patientNameTxtField.getText());
        patient.setAge(Integer.parseInt(patientAgeTxtField.getText()));
        
        if (patient.getPrimaryDoctor() == null) {
            if ((PrimaryDoctor) primaryDoctorComboBox.getSelectedItem() != null) {
                patient.setPrimaryDoctor((PrimaryDoctor) primaryDoctorComboBox.getSelectedItem());
                ((PrimaryDoctor) primaryDoctorComboBox.getSelectedItem()).getPrimaryDoctorsPatientList().add(patient);
            }
        }
        
        JOptionPane.showMessageDialog(this, "Profile Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
        updateBtn.setEnabled(true);
        saveBtn.setEnabled(false);
        patientLocationTxtField.setEditable(false);
        patientNameTxtField.setEditable(false);
        patientAgeTxtField.setEditable(false);
        primaryDoctorComboBox.setEnabled(false);
        patientBloodGroupComboBox.setEnabled(false);
        patientInsuranceComboBox.setEnabled(false);
        populateTxtFields();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        pwajp.isProfileComplete();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void primaryDoctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primaryDoctorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primaryDoctorComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField patientAgeTxtField;
    private javax.swing.JComboBox patientBloodGroupComboBox;
    private javax.swing.JTextField patientIDTxtField;
    private javax.swing.JComboBox patientInsuranceComboBox;
    private javax.swing.JTextField patientLocationTxtField;
    private javax.swing.JTextField patientNameTxtField;
    private javax.swing.JComboBox primaryDoctorComboBox;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void populateTxtFields() {
        patientNameTxtField.setText(patient.getName());
        patientAgeTxtField.setText(String.valueOf(patient.getAge()));
        patientIDTxtField.setText(String.valueOf(patient.getId()));
        
        //patientEmergencyContactTxtField.setText(patient.getEmergencyContact().getName());
        patientLocationTxtField.setText(String.valueOf(patient.getLocation()));
        if (patient.getPrimaryDoctor() != null) {
            primaryDoctorComboBox.removeAllItems();
            primaryDoctorComboBox.addItem(patient.getPrimaryDoctor().getName());
        }
        patientBloodGroupComboBox.removeAllItems();
        patientInsuranceComboBox.removeAllItems();
        patientBloodGroupComboBox.addItem(patient.getBloodGroup());
        patientInsuranceComboBox.addItem(patient.getInsuranceInfo());
    }

    private void populateComboBox() {
        PrimaryDoctor primaryDoc = null;
        primaryDoctorComboBox.removeAllItems();
        primaryDoctorComboBox.addItem(primaryDoc);
        for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (ent instanceof PrimaryDoctorsClinicEnterprise) {
                pdcEnterprise = (PrimaryDoctorsClinicEnterprise) ent;
                for (Organization org : pdcEnterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof PDCPrimaryDoctorOrganization) {
                        org = (PDCPrimaryDoctorOrganization) org;
                        for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                            if (emp instanceof PrimaryDoctor) {
                                primaryDoc = (PrimaryDoctor) emp;
                                primaryDoctorComboBox.addItem(primaryDoc);
                            }
                        }
                    }
                }
            }
        }

    }

    private void populateInsuranceAndBloodGroupComboBox() {
       patientInsuranceComboBox.removeAllItems();
       patientBloodGroupComboBox.removeAllItems();
       String[] bloodGroup = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
       for(int i = 0; i<8;i++){
           patientBloodGroupComboBox.addItem(bloodGroup[i]);
       }
       
       String[] insuranceCompanies = {"BCBS","ISO","Aetna", "Cigna", "Fortis"};
       for(int i = 0; i<5;i++){
           patientInsuranceComboBox.addItem(insuranceCompanies[i]);
       }
       
    }
}