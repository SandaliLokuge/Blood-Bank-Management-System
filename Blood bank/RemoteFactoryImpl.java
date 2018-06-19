package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteFactoryImpl extends UnicastRemoteObject implements RemoteFactory{
	public RemoteFactoryImpl()throws RemoteException{
		
	}
	public DonorController getDonorController() throws RemoteException {
		return new DonorControllerImpl();
    }
    public BloodSampleController getBloodSampleController() throws RemoteException{
		return new BloodSampleControllerImpl();
	}
	public PatientController getPatientController() throws RemoteException{
		return new PatientControllerImpl();
	}
	public GuardianController getGuardianController() throws RemoteException{
		return new GuardianControllerImpl();
	}
	public IssuebloodController getIssuebloodController() throws RemoteException{
		return new IssuebloodControllerImpl();
	}
}
