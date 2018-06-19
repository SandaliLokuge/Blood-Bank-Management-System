package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;
import server.ijse.rmi.bloodbank.observerble.BloodSampleObserverble;
import server.ijse.rmi.bloodbank.reserver.BloodSampleReserver;
import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import server.ijse.rmi.bloodbank.fileaccess.BloodsampleFileAccess;
import common.ijse.rmi.bloodbank.model.BloodSample;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.ijse.rmi.bloodbank.observerble.DonorObserverble;

public class BloodSampleControllerImpl extends UnicastRemoteObject implements BloodSampleController {

    private static final BloodSampleObserverble BLOODSAMPLE_OBSERVERBLE = new BloodSampleObserverble();
    private static final BloodSampleReserver BLOOD_SAMPLE_RESERVER = new BloodSampleReserver();
    private BloodsampleFileAccess bloodsampleFileAccess = new BloodsampleFileAccess();

    public BloodSampleControllerImpl() throws RemoteException {
    }

    public boolean addBloodSample(BloodSample bloodsample) throws RemoteException, ClassNotFoundException, IOException {
        boolean isAdded = bloodsampleFileAccess.addBloodSample(bloodsample);
        final String bid=bloodsample.getDonorid();
        if (isAdded) {
            new Thread() {
                public void run() {
                    try {
                        BLOODSAMPLE_OBSERVERBLE.setMessage(new String("New blood sample is entered to the bloodbank"+"-"+bid));
                    } catch (RemoteException e) {
                    }
                }
            }.start();
        }

        return isAdded;
    }

    public BloodSample searchBloodSample(String donorid) throws RemoteException, ClassNotFoundException, IOException {
        return bloodsampleFileAccess.searchBloodSample(donorid);

    }

    public List<BloodSample> getallBloodSamples() throws RemoteException, ClassNotFoundException, IOException {
        return bloodsampleFileAccess.getallBloodSamples();
    }

    public List<BloodSample> getBloodSamplesbyBloodgroup(String bloodgroup) throws RemoteException, ClassNotFoundException, IOException {
        return bloodsampleFileAccess.getBloodSamplesbyBloodgroup(bloodgroup);
    }

    public List<BloodSample> getBloodSamplesbyBloodcomp(String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        return bloodsampleFileAccess.getBloodSamplesbyBloodcomp(bloodcomponent);
    }

    public List<BloodSample> getBloodSamples(String bloodgroup, String bloodcomponent) throws RemoteException, ClassNotFoundException, IOException {
        return bloodsampleFileAccess.getBloodSamples(bloodgroup, bloodcomponent);
    }

    public List<BloodSample> getDonations(String donorid) throws RemoteException, ClassNotFoundException, IOException {
        return bloodsampleFileAccess.getDonations(donorid);
    }

    public boolean reserveBloodSample(String id) throws RemoteException {
        return BLOOD_SAMPLE_RESERVER.reserveBloodSample(id, this);
    }

    public boolean releaseBloodSample(String id) throws RemoteException {
        return BLOOD_SAMPLE_RESERVER.releaseBloodSample(id, this);
    }

    public void addBloodSampleObserver(BloodSampleObserver bloodSampleObserver) throws RemoteException {
        BLOODSAMPLE_OBSERVERBLE.addBloodSampleObserver(bloodSampleObserver);
    }

    public void removeBloodSampleObserver(BloodSampleObserver bloodSampleObserver) throws RemoteException {
        BLOODSAMPLE_OBSERVERBLE.removeBloodSampleObserver(bloodSampleObserver);
    }


    public String getLastBloodSampleId() throws RemoteException, ClassNotFoundException, IOException {
        return bloodsampleFileAccess.getLastId();
    }
}
