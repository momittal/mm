/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ERCoordinatorRole;

import Business.Enterprise.Enterprise;
import Business.Organization.ERGeneralDoctorTeamOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import static Business.Utils.Methods.getLastERVisit;
import Business.WorkQueue.RequestAmbulanceERCoordinator;
import Business.WorkQueue.RequestERCoordinatorERGeneral;
import Business.WorkQueue.RequestPatientAmbulance;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohit
 */
public class ERCoordinatorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;

    /**
     * Creates new form ERCoordinatorWorkAreaJPanel
     */
    public ERCoordinatorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.organization = organization;
        populateIncomingPatientListTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        incomingPatientListTable = new javax.swing.JTable();
        acceptPatientBtn = new javax.swing.JButton();
        assignTeamBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ER Coordinator Work Area");

        incomingPatientListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ambulance", "Patient", "Patient Normal", "Status"
            }
        ));
        jScrollPane1.setViewportView(incomingPatientListTable);

        acceptPatientBtn.setText("Accept Patient");
        acceptPatientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptPatientBtnActionPerformed(evt);
            }
        });

        assignTeamBtn.setText("Assign Doctor's Team");
        assignTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignTeamBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 240, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(333, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(acceptPatientBtn)
                        .addGap(382, 382, 382)
                        .addComponent(assignTeamBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptPatientBtn)
                    .addComponent(assignTeamBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptPatientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptPatientBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = incomingPatientListTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        } else {
            WorkRequest request2 = (WorkRequest) incomingPatientListTable.getModel().getValueAt(selectedRow, 0);
            if (request2.getStatus().equalsIgnoreCase("Patient Dropped To Emergency Room")
                    || request2.getStatus().equalsIgnoreCase("Patient Admitted")) {
                request2.setStatus("Patient Admitted");
                WorkRequest lastRequest = null;
                for (WorkRequest request : request2.getPatient().getUserAccount().getWorkQueue().getWorkRequestList()) {
                    if (request instanceof RequestPatientAmbulance) {
                        lastRequest = request;
                    }
                }
                if(lastRequest!= null){
                lastRequest.setStatus("Patient Admitted");
                }
                populateIncomingPatientListTable();
            }

        }
        JOptionPane.showMessageDialog(null, "Patient Admitted");
    }//GEN-LAST:event_acceptPatientBtnActionPerformed

    private void assignTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignTeamBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = incomingPatientListTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        } else {
            WorkRequest request2 = (WorkRequest) incomingPatientListTable.getModel().getValueAt(selectedRow, 0);
            if (getLastERVisit(request2).isStatusNormalInAmbulance()) {
                RequestERCoordinatorERGeneral request4 = new RequestERCoordinatorERGeneral();
                request4.setPatient(request2.getPatient());
                request4.setStatus("General Team Assigned by ER Coordinator");
                WorkRequest lastRequest = null;
                for (WorkRequest request : request4.getPatient().getUserAccount().getWorkQueue().getWorkRequestList()) {
                    if (request instanceof RequestPatientAmbulance) {
                        lastRequest = request;
                        
                    }
                }
                if(lastRequest!= null){
                lastRequest.setStatus("General Team Assigned by ER Coordinator");
                request2.setStatus("General Team Assigned by ER Coordinator");
                }
                request4.setMessage("Call Ambulance");

                request4.setSender(userAccount);

                Organization org = null;
                for (Organization org1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org1 instanceof ERGeneralDoctorTeamOrganization) {
                        org = org1;
                        break;
                    }
                }
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(request4);
                    userAccount.getWorkQueue().getWorkRequestList().add(request4);
                }

                JOptionPane.showMessageDialog(null, "Doctor Team Assigned");
            } else {
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                userProcessContainer.add("ERCoordinatorAssignTeamJPanel", new ERCoordinatorAssignTeamJPanel(userProcessContainer, userAccount, organization, enterprise, request2, this));
                layout.next(userProcessContainer);
            }
            populateIncomingPatientListTable();
        }
    }//GEN-LAST:event_assignTeamBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptPatientBtn;
    private javax.swing.JButton assignTeamBtn;
    private javax.swing.JTable incomingPatientListTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void populateIncomingPatientListTable() {
        DefaultTableModel dtm = (DefaultTableModel) incomingPatientListTable.getModel();
        dtm.setRowCount(0);
        Object row[] = new Object[4];

        for (WorkRequest request2 : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request2 instanceof RequestAmbulanceERCoordinator) {
                row[0] = request2;
                row[1] = request2.getPatient();
                //row[2] = "In Patient // set this from ambulance";
                int size = request2.getPatient().getErVisitHistory().getErVisitHistory().size();
                String status = "Low Risk";
                if (!request2.getPatient().getErVisitHistory().getErVisitHistory().get(size - 1).isStatusNormalInAmbulance()){
                    status = "Hign Risk";
                }
                row[2] = status;
                row[3] = request2.getStatus();
                dtm.addRow(row);
            }
        }

    }

}
