/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.cmjd.rmi.bbms.client.idgenerator;

import edu.ijse.cmjd.rmi.bbms.client.serverconnector.ServerConnector;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import common.ijse.rmi.bloodbank.controller.DonorController;
import common.ijse.rmi.bloodbank.controller.GuardianController;
import common.ijse.rmi.bloodbank.controller.IssuebloodController;
import common.ijse.rmi.bloodbank.controller.PatientController;
import common.ijse.rmi.bloodbank.model.BloodSample;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandali
 */
public class IdGenerator {

    public String createBloodSampleId() throws RemoteException, ClassNotFoundException, IOException, NotBoundException {
        BloodSampleController bloodSampleController = ServerConnector.getServerConnector().getBloodSampleController();
        String bloodId = bloodSampleController.getLastBloodSampleId();
        if (bloodId != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(bloodId, "B");
            NumberFormat numberFormat = new DecimalFormat();
            numberFormat.setMinimumIntegerDigits(6);
            numberFormat.setGroupingUsed(false);
            int id = Integer.parseInt(stringTokenizer.nextToken()) + 1;
            String newId = numberFormat.format(id);
            return newId + "B";
        } else {
            return "000001B";
        }
    }

    public String createDonorId() throws RemoteException, ClassNotFoundException, IOException, NotBoundException {
        DonorController donorController = ServerConnector.getServerConnector().getDonorController();
        String donordId = donorController.getLastDonorId();
        if (donordId != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(donordId, "D");
            NumberFormat numberFormat = new DecimalFormat();
            numberFormat.setMinimumIntegerDigits(6);
            numberFormat.setGroupingUsed(false);
            int id = Integer.parseInt(stringTokenizer.nextToken()) + 1;
            String newId = numberFormat.format(id);
            return newId + "D";
        } else {
            return "000001D";
        }
    }


    public String createPatientId() throws RemoteException, ClassNotFoundException, IOException, NotBoundException {
        PatientController patientController = ServerConnector.getServerConnector().getPatientController();
        String patientId = patientController.getLastPatientId();
        if (patientId != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(patientId, "P");
            NumberFormat numberFormat = new DecimalFormat();
            numberFormat.setMinimumIntegerDigits(6);
            numberFormat.setGroupingUsed(false);
            int id = Integer.parseInt(stringTokenizer.nextToken()) + 1;
            String newId = numberFormat.format(id);
            return newId + "P";
        } else {
            return "000001P";
        }
    }

    public String createGuardianId() throws RemoteException, ClassNotFoundException, IOException, NotBoundException {
        GuardianController guardianController = ServerConnector.getServerConnector().getGuardianController();
        String guardianId = guardianController.getLastGuardianId();
        if (guardianId != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(guardianId, "G");
            NumberFormat numberFormat = new DecimalFormat();
            numberFormat.setMinimumIntegerDigits(6);
            numberFormat.setGroupingUsed(false);
            int id = Integer.parseInt(stringTokenizer.nextToken()) + 1;
            String newId = numberFormat.format(id);
            return newId + "G";
        } else {
            return "000001G";
        }
    }
}
