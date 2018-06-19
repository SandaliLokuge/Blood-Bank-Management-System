/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.BloodCampController;
import common.ijse.rmi.bloodbank.controller.BloodReqController;
import common.ijse.rmi.bloodbank.model.BloodCamp;
import common.ijse.rmi.bloodbank.model.BloodReq;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.ijse.rmi.bloodbank.fileaccess.BloodReqFileAccess;
import server.ijse.rmi.bloodbank.observerble.BloodReqObserverble;
import server.ijse.rmi.bloodbank.reserver.BloodReqReserver;

/**
 *
 * @author Sandali
 */
public class BloodReqControllerImpl extends UnicastRemoteObject implements BloodReqController {

    private static final BloodReqObserverble BLOOD_REQ_OBSERVERBLE = new BloodReqObserverble();
    private static final BloodReqReserver BLOOD_REQ_RESERVER = new BloodReqReserver();
    private BloodReqFileAccess bloodReqFileAccess = new BloodReqFileAccess();

    public BloodReqControllerImpl() throws RemoteException {
    }

    public boolean addBloodreq(BloodReq bloodreq) throws RemoteException, ClassNotFoundException, IOException {
        return bloodReqFileAccess.addBloodreq(bloodreq);
    }

    public List<BloodReq> getallBloodReqs() throws RemoteException, ClassNotFoundException, IOException {
        return bloodReqFileAccess.getallBloodReqs();
    }

    public boolean deleteBloodReq(String name) throws RemoteException, ClassNotFoundException, IOException {
        boolean isDeleted = bloodReqFileAccess.deleteBloodReq(name);
        final String n=name;
        if (isDeleted) {
            new Thread() {
                public void run() {
                    try {
                        BLOOD_REQ_OBSERVERBLE.setMessage(new String("Blood requirement is ok" + "-" + n));
                    } catch (RemoteException e) {
                    }
                }
            }.start();
        }

        return isDeleted;
    }
}
