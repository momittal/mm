/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Patient;

import Business.Employee.Employee;
import Business.Employee.Patient;
import Business.Enterprise.EmergencyRoomEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AmbulanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.RequestPatientAmbulance;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mohit
 */
public class PatientCallAmbulanceJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Patient patient;
    private Network network;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private PatientWorkAreaJPanel pwajp;
    /**
     * Creates new form PatientCallAmbulanceJPanel
     */
    public PatientCallAmbulanceJPanel(JPanel userProcessContainer, Patient patient, Network network, UserAccount userAccount, PatientWorkAreaJPanel pwajp) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patient = patient;
        this.network = network;
        this.userAccount = userAccount;
        this.pwajp = pwajp;
        for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (ent instanceof EmergencyRoomEnterprise) {
                this.enterprise = ent;
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof AmbulanceOrganization) {
                        this.organization = org;
                    }
                }
                populateAmbulanceTable();
            }
        }
        arrangeTableInAscending();
        ambulanceListJTable.setRowSelectionInterval(0, 0);
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
        ambulanceListJTable = new javax.swing.JTable();
        assignAmbulanceBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        ambulanceListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ambulance ID", "Ambulance Name", "Time to Reach Patient(Min)", "Organization", "Enterprise"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ambulanceListJTable);
        if (ambulanceListJTable.getColumnModel().getColumnCount() > 0) {
            ambulanceListJTable.getColumnModel().getColumn(3).setHeaderValue("Organization");
            ambulanceListJTable.getColumnModel().getColumn(4).setHeaderValue("Enterprise");
        }

        assignAmbulanceBtn.setText("Call Ambulance");
        assignAmbulanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignAmbulanceBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Closest Ambulance and Assign");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(252, 252, 252))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(assignAmbulanceBtn)))
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(assignAmbulanceBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignAmbulanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignAmbulanceBtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = ambulanceListJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        } else {
            Employee ambulance = (Employee) ambulanceListJTable.getValueAt(selectedRow, 1) ;
            organization = (Organization) ambulanceListJTable.getModel().getValueAt(selectedRow, 3) ;
            enterprise = (Enterprise) ambulanceListJTable.getModel().getValueAt(selectedRow, 4) ;
            //JOptionPane.showMessageDialog(null,"Selected Org is " + organization +" Ent is " + enterprise +" User Account is" + ambulance.getUserAccount().getUsername());
           
            RequestPatientAmbulance request = new RequestPatientAmbulance();
            request.setReceiver(ambulance.getUserAccount());
            request.setStatus("Ambulance Called by Patient");
            request.setMessage("Call Ambulance");
            request.setSender(patient.getUserAccount());
            
            
            if (organization != null) {
                ambulance.getUserAccount().getWorkQueue().getWorkRequestList().add(request);
                patient.getUserAccount().getWorkQueue().getWorkRequestList().add(request);
            }
        }
        JOptionPane.showMessageDialog(null, "Ambulance Assigned");
        assignAmbulanceBtn.setEnabled(false);
    }//GEN-LAST:event_assignAmbulanceBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        pwajp.populateWorkRequestTable();
        pwajp.isPatientVisitinDoctorOrER();
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ambulanceListJTable;
    private javax.swing.JButton assignAmbulanceBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void populateAmbulanceTable() {
        DefaultTableModel dtm = (DefaultTableModel) ambulanceListJTable.getModel();
        //dtm.setRowCount(0);
        ambulanceListJTable.setAutoCreateRowSorter(true);
        Object row[] = new Object[5];
        //location attribute is needed for every thing like ambulance, volunteer, hospital etc.
        int patientLocation = patient.getLocation();
        for (Employee ambulance : organization.getEmployeeDirectory().getEmployeeList()) {
            row[0] = ambulance.getId();
            row[1] = ambulance;
            row[2] = Math.abs((ambulance.getLocation() - patientLocation));
            row[3] = organization;
            row[4] = enterprise;
            dtm.addRow(row);
        }
        //ambulanceListJTable.removeColumn(ambulanceListJTable.getColumnModel().getColumn(3));       //this line removes the column from the view but not from the model. to get values model is used
    }

    private void arrangeTableInAscending() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(ambulanceListJTable.getModel());
        ambulanceListJTable.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = 2;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
}
