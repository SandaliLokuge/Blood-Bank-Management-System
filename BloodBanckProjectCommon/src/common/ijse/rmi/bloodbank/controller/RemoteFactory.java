package common.ijse.rmi.bloodbank.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteFactory extends Remote {

    public DonorController getDonorController() throws RemoteException;

    public BloodSampleController getBloodSampleController() throws RemoteException;

    public PatientController getPatientController() throws RemoteException;

    public GuardianController getGuardianController() throws RemoteException;

    public IssuebloodController getIssuebloodController() throws RemoteException;

    public UserController getUserController() throws RemoteException;

    public BloodReqController getBloodReqController() throws RemoteException;

    public BloodCampController getBloodCampController() throws RemoteException;
}
