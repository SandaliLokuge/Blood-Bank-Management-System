package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.observer.DonorObserver;
import server.ijse.rmi.bloodbank.observerble.DonorObserverble;
import server.ijse.rmi.bloodbank.reserver.DonorReserver;
import common.ijse.rmi.bloodbank.controller.DonorController;
import server.ijse.rmi.bloodbank.fileaccess.DonorFileAccess;
import common.ijse.rmi.bloodbank.model.Donor;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DonorControllerImpl extends UnicastRemoteObject implements DonorController {

    private static final DonorObserverble DONOR_OBSERVERBLE = new DonorObserverble();
    private static final DonorReserver donorReserver = new DonorReserver();
    private DonorFileAccess donorFileAccess = new DonorFileAccess();

    public DonorControllerImpl() throws RemoteException {
    }

    public boolean addDonor(Donor donor) throws RemoteException, ClassNotFoundException, IOException {
        boolean isAdded = donorFileAccess.addDonor(donor);
        if (isAdded) {
            new Thread() {
                public void run() {
                    try {
                        DONOR_OBSERVERBLE.setMessage(new String("New donor is added.Wait to reload till the blood sample is added"));
                    } catch (RemoteException e) {
                    }
                }
            }.start();
        }
        return isAdded;
    }

    public boolean updateDonor(Donor donor) throws RemoteException, ClassNotFoundException, IOException {
        boolean isUpdated = donorFileAccess.updateDonor(donor);
        if (isUpdated) {
            new Thread() {
                public void run() {
                    try {
                        DONOR_OBSERVERBLE.setMessage(new String("A donor is updated"));
                    } catch (RemoteException ex) {
                    }
                }
            }.start();
        }
        return isUpdated;
    }

    public Donor searchDonorBynic(String nic) throws RemoteException, ClassNotFoundException, IOException {
        return donorFileAccess.searchDonorBynic(nic);
    }

    public Donor searchDonorByid(String donorid) throws RemoteException, ClassNotFoundException, IOException {
        return donorFileAccess.searchDonorByid(donorid);
    }

    public List<Donor> getallDonors() throws RemoteException, ClassNotFoundException, IOException {
        return donorFileAccess.getallDonors();
    }

    public boolean reserveDonor(String id) throws RemoteException {
        return donorReserver.reserveDonor(id, this);
    }

    public boolean releaseDonor(String id) throws RemoteException {
        return donorReserver.releaseDonor(id, this);
    }

    public void addDonorObserver(DonorObserver donorObserver) throws RemoteException {
        DONOR_OBSERVERBLE.addDonorObserver(donorObserver);
    }

    public void removeDonorObserver(DonorObserver donorObserver) throws RemoteException {
        DONOR_OBSERVERBLE.removeDonorObserver(donorObserver);
    }

    public String getLastDonorId() throws RemoteException, ClassNotFoundException, IOException {
        return donorFileAccess.getLastId();
    }

    public List<Donor> getallDonorsbybloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException{
        return donorFileAccess.getallDonorsbybloodgroup(bloodgroup);
    }
}
