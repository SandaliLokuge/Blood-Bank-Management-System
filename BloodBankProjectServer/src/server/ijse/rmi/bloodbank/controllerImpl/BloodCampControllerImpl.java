/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.BloodCampController;
import common.ijse.rmi.bloodbank.model.BloodCamp;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.ijse.rmi.bloodbank.fileaccess.BloodCampFileAccess;
import server.ijse.rmi.bloodbank.observerble.BloodCampObserverble;

/**
 *
 * @author Sandali
 */
public class BloodCampControllerImpl extends UnicastRemoteObject implements BloodCampController {

    private static final BloodCampObserverble BLOOD_CAMP_OBSERVERBLE = new BloodCampObserverble();
    private BloodCampFileAccess bloodCampFileAccess = new BloodCampFileAccess();

    public BloodCampControllerImpl() throws RemoteException {
    }

    public boolean addBloodCamp(BloodCamp bloodcamp) throws RemoteException, ClassNotFoundException, IOException {
        boolean isAdded = bloodCampFileAccess.addBloodCamp(bloodcamp);
        if (isAdded) {
            new Thread() {
                public void run() {
                    try {
                        BLOOD_CAMP_OBSERVERBLE.setMessage(new String("New blood camp is added"));
                    } catch (RemoteException e) {
                    }
                }
            }.start();
        }

        return isAdded;
    }

    public List<BloodCamp> getallBloodCamps() throws RemoteException, ClassNotFoundException, IOException {
        return bloodCampFileAccess.getallBloodCamps();
    }

    public boolean deleteBloodCamp(String date) throws RemoteException, ClassNotFoundException, IOException {
       return bloodCampFileAccess.deleteBloodCamp(date);
    }
}
