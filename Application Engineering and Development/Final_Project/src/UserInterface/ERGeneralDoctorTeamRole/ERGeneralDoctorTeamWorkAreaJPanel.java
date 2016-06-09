/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ERGeneralDoctorTeamRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
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
public class ERGeneralDoctorTeamWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;

    /**
     * Creates new form ERGeneralDoctorTeamWorkAreaJPanel
     */
    public ERGeneralDoctorTeamWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        erGeneralRequestTable = new javax.swing.JTable();
        monitorAndOperatePatientBtn = new javax.swing.JButton();
        assignPatientToMeBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        erGeneralRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sender", "Patient", "Status", "Receiver"
            }
        ));
        jScrollPane1.setViewportView(erGeneralRequestTable);

        monitorAndOperatePatientBtn.setText("Monitor and Operate Patient");
        monitorAndOperatePatientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorAndOperatePatientBtnActionPerformed(evt);
            }
        });

        assignPatientToMeBtn.setText("Assign Patient To My Team");
        assignPatientToMeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignPatientToMeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(assignPatientToMeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(monitorAndOperatePatientBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monitorAndOperatePatientBtn)
                    .addComponent(assignPatientToMeBtn))
                .addGap(371, 371, 371))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void monitorAndOperatePatientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorAndOperatePatientBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = erGeneralRequestTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        } else {
            RequestERCoordinatorERGeneral request4 = (RequestERCoordinatorERGeneral) erGeneralRequestTable.getValueAt(selectedRow, 0);

            if (request4.getMessage().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Patient already Treated");
                return;
            } else {
                request4.setStatus("Moitoring Patient");
                WorkRequest lastRequest = null;
                for (WorkRequest request : request4.getPatient().getUserAccount().getWorkQueue().getWorkRequestList()) {
                    if (request instanceof RequestPatientAmbulance) {
                        lastRequest = request;
                    }
                }

                if (lastRequest != null) {
                    lastRequest.setStatus("Moitoring Patient");
                }
                ERGeneralDoctorProcessJPanel erGeneralDoctorProcessJPanel = new ERGeneralDoctorProcessJPanel(userProcessContainer, request4, this);
                userProcessContainer.add("erGeneralDoctorProcessJPanel", erGeneralDoctorProcessJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }

        }
    }//GEN-LAST:event_monitorAndOperatePatientBtnActionPerformed

    private void assignPatientToMeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignPatientToMeBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = erGeneralRequestTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        } else {
            WorkRequest request4 = (WorkRequest) erGeneralRequestTable.getValueAt(selectedRow, 0);
            if (request4.getMessage().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Patient already Treated");
                return;
            } else {
                request4.setReceiver(userAccount);
                request4.setStatus("Doctor Team Assigned");
                WorkRequest lastRequest = null;
                for (WorkRequest request : request4.getPatient().getUserAccount().getWorkQueue().getWorkRequestList()) {
                    if (request instanceof RequestPatientAmbulance) {
                        lastRequest = request;
                    }
                }
                if (lastRequest != null) {
                    lastRequest.setStatus("Doctor Team Assigned");
                }
                populateTable();
            }
        }
    }//GEN-LAST:event_assignPatientToMeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignPatientToMeBtn;
    private javax.swing.JTable erGeneralRequestTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton monitorAndOperatePatientBtn;
    // End of variables declaration//GEN-END:variables

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) erGeneralRequestTable.getModel();
        dtm.setRowCount(0);
        Object[] row = new Object[4];

        for (WorkRequest request4 : organization.getWorkQueue().getWorkRequestList()) {
            row[0] = request4;
            row[1] = request4.getPatient();
            row[2] = request4.getStatus();
            row[3] = request4.getReceiver();
            dtm.addRow(row);
        }
    }
}
