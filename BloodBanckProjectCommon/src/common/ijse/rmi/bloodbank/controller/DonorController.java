package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.Donor;
import common.ijse.rmi.bloodbank.observer.DonorObserver;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DonorController extends Remote {

    public boolean addDonor(Donor donor) throws RemoteException, ClassNotFoundException, IOException;

    public boolean updateDonor(Donor donor) throws RemoteException, ClassNotFoundException, IOException;

    public Donor searchDonorBynic(String nic) throws RemoteException, ClassNotFoundException, IOException;

    public String getLastDonorId() throws RemoteException, ClassNotFoundException, IOException;

    public Donor searchDonorByid(String donorid) throws RemoteException, ClassNotFoundException, IOException;

    public List<Donor> getallDonors() throws RemoteException, ClassNotFoundException, IOException;
    
    public List<Donor> getallDonorsbybloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException;

    public boolean reserveDonor(String id) throws RemoteException;

    public boolean releaseDonor(String id) throws RemoteException;

    public void addDonorObserver(DonorObserver donorObserver) throws RemoteException;

    public void removeDonorObserver(DonorObserver donorObserver) throws RemoteException;
}
