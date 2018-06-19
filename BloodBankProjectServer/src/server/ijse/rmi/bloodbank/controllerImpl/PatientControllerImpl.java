package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.PatientController;
import server.ijse.rmi.bloodbank.fileaccess.PatientFileAccess;
import common.ijse.rmi.bloodbank.model.Patient;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PatientControllerImpl extends UnicastRemoteObject implements PatientController {

    private PatientFileAccess patientFileAccess = new PatientFileAccess();

    public PatientControllerImpl() throws RemoteException {
    }

    public boolean addPatient(Patient patient) throws RemoteException, ClassNotFoundException, IOException {
        return patientFileAccess.addPatient(patient);
    }

    public Patient searchPatientByid(String patientid) throws RemoteException, ClassNotFoundException, IOException {
        return patientFileAccess.searchPatientByid(patientid);
    }

    public String getLastPatientId() throws RemoteException, ClassNotFoundException, IOException {
        return patientFileAccess.getLastId();
    }
}
