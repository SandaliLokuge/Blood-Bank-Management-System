package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BloodSampleController extends Remote {

    public boolean addBloodSample(BloodSample bloodsample) throws RemoteException, ClassNotFoundException, IOException;

    public BloodSample searchBloodSample(String donorid) throws RemoteException, ClassNotFoundException, IOException;

    public String getLastBloodSampleId() throws RemoteException, ClassNotFoundException, IOException;

    public List<BloodSample> getallBloodSamples() throws RemoteException, ClassNotFoundException, IOException;

    public List<BloodSample> getBloodSamplesbyBloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException;

    public List<BloodSample> getBloodSamplesbyBloodcomp(String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException;

    public List<BloodSample> getBloodSamples(String bloodgroup, String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException;

    public List<BloodSample> getDonations(String donorid) throws RemoteException, ClassNotFoundException, IOException;

    public boolean reserveBloodSample(String id) throws RemoteException;

    public boolean releaseBloodSample(String id) throws RemoteException;

    public void addBloodSampleObserver(BloodSampleObserver bloodSampleObserver) throws RemoteException;

    public void removeBloodSampleObserver(BloodSampleObserver bloodSampleObserver) throws RemoteException;
}
