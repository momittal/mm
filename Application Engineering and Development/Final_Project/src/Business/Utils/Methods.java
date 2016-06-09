/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import Business.Employee.Patient;
import Business.PatientAttributes.ERVisit;
import Business.PatientAttributes.VitalSigns;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mohit
 */
public class Methods {

    public static int randomNum(int i, int j) {
        int randomNum = 0;
        Random randomGenerator = new Random();
        int range = j - i + 1;
        int fraction = (int) (range * randomGenerator.nextDouble());
        randomNum = (fraction + i);
        return randomNum;
    }

    public static boolean vitalSignsStatusChecker(int ecg) {
        boolean status;
        if (ecg <= 45) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }

    public static ERVisit getLastERVisit(WorkRequest request) {
        int size = request.getPatient().getErVisitHistory().getErVisitHistory().size();
        ERVisit erVisit = request.getPatient().getErVisitHistory().getErVisitHistory().get(size - 1);
        return erVisit;
    }

    public static void arrangeTableInDescending(JTable table, int colIndex) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = colIndex;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    public static void arrangeTableInAscending(JTable table, int colIndex) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int columnIndexToSort = colIndex;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    public static void inputVitalSigns(Patient patient) {

        int respRate = 0, heartRate = 0, bloodPressure = 0, weightInKg = 0, ecg = 0;
//      
        int size = patient.getVitalSignsHistory().getVitalSignsHistory().size();
        if (size > 0) {
            VitalSigns previousVS = patient.getVitalSignsHistory().getVitalSignsHistory().get(size - 1);
            if (previousVS.isStatus()) {
                respRate = randomNum(10, 30); //12-25
                heartRate = randomNum(51, 100); // 60-90
                bloodPressure = randomNum(50, 100); // 70-90-120-190
                weightInKg = randomNum(80, 85); //80-85
                ecg = randomNum(45, 49);    //80% chance of normal
                
            }
            else{
                respRate = randomNum(5, 17); //12-25
                heartRate = randomNum(100, 150); // 60-90
                bloodPressure = randomNum(120, 160); // 70-90-120-190
                weightInKg = randomNum(80, 85); 
                ecg = randomNum(42, 46);    //20 % chance of normal
            }

        } else {
            respRate = randomNum(10, 30); //12-25
            heartRate = randomNum(51, 100); // 60-90
            bloodPressure = randomNum(90, 120); // 70-90-120-190
            weightInKg = randomNum(80, 85); // 80-85
            ecg = randomNum(43, 52);   //  70% chance of normal
        }

        

        VitalSigns vitalSigns = patient.getVitalSignsHistory().addVitalSigns();
        vitalSigns.setRespiratoryRate(respRate);
        vitalSigns.setHeartRate(heartRate);
        vitalSigns.setSystolicBloodPressure(bloodPressure);
        vitalSigns.setWeightInKg(weightInKg);
        vitalSigns.setEcg(ecg);
        vitalSigns.setTimeStamp(new Date());
        vitalSigns.setStatus(vitalSignsStatusChecker(ecg));

    }

}
