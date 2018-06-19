package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.Patient;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PatientController extends Remote {

    public boolean addPatient(Patient patient) throws RemoteException, ClassNotFoundException, IOException;

    public Patient searchPatientByid(String patientid) throws RemoteException, ClassNotFoundException, IOException;

    public String getLastPatientId() throws RemoteException, ClassNotFoundException, IOException;
}
