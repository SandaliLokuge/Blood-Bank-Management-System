package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.observer.IssuebloodObserver;
import common.ijse.rmi.bloodbank.model.Issueblood;
import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IssuebloodController extends Remote {

    public boolean addIssueblood(Issueblood issueblood) throws RemoteException, ClassNotFoundException, IOException;

    public List<Issueblood> getallIssueblood() throws RemoteException, ClassNotFoundException, IOException;

    public List<Issueblood> getIssuebloodbyBloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException;

    public List<Issueblood> getIssuebloodbyBloodcomp(String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException;

    public List<Issueblood> getIssueblood(String bloodgroup, String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException;

    public void addIssuebloodObserver(IssuebloodObserver issuebloodObserver) throws RemoteException;

    public void removeIssuebloodObserver(IssuebloodObserver issuebloodObserver) throws RemoteException;
}
