package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.IssuebloodController;
import server.ijse.rmi.bloodbank.fileaccess.IssuebloodFileAccess;
import common.ijse.rmi.bloodbank.model.Issueblood;
import common.ijse.rmi.bloodbank.observer.IssuebloodObserver;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.ijse.rmi.bloodbank.observerble.IssuedbloodObserverble;
import server.ijse.rmi.bloodbank.reserver.BloodSampleReserver;


public class IssuebloodControllerImpl extends UnicastRemoteObject implements IssuebloodController {

    private IssuebloodFileAccess issuebloodFileAccess = new IssuebloodFileAccess();
    private static final IssuedbloodObserverble ISSUEBLOOD_OBSERVERBLE = new IssuedbloodObserverble();

    public IssuebloodControllerImpl() throws RemoteException {
    }

    public boolean addIssueblood(Issueblood issueblood) throws RemoteException, ClassNotFoundException, IOException {
        boolean isIssued = issuebloodFileAccess.addIssueblood(issueblood);
        if (isIssued) {
            new Thread() {
                public void run() {
                    try {
                        ISSUEBLOOD_OBSERVERBLE.setMessage(new String("New blood sample is issued from the bloodbank"));
                    } catch (RemoteException e) {
                    }
                }
            }.start();
        }

        return isIssued;
    }

    public List<Issueblood> getallIssueblood() throws RemoteException, ClassNotFoundException, IOException {
        return issuebloodFileAccess.getallIssueblood();
    }

    public List<Issueblood> getIssuebloodbyBloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException {
        return issuebloodFileAccess.getIssuebloodbyBloodgroup(bloodgroup);
    }

    public List<Issueblood> getIssuebloodbyBloodcomp(String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        return issuebloodFileAccess.getIssuebloodbyBloodcomp(bloodcomponent);
    }

    public List<Issueblood> getIssueblood(String bloodgroup, String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        return issuebloodFileAccess.getIssueblood(bloodgroup, bloodcomponent);
    }


    public void addIssuebloodObserver(IssuebloodObserver issuebloodObserver) throws RemoteException {
        ISSUEBLOOD_OBSERVERBLE.addIssuebloodObserver(issuebloodObserver);
    }

    public void removeIssuebloodObserver(IssuebloodObserver issuebloodObserver) throws RemoteException {
        ISSUEBLOOD_OBSERVERBLE.removeIssuebloodObserver(issuebloodObserver);
    }

}
