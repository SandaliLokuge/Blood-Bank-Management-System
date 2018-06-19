/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.BloodReq;
import common.ijse.rmi.bloodbank.model.BloodCamp;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Sandali
 */
public interface BloodReqController extends Remote {

    public boolean addBloodreq(BloodReq bloodreq) throws RemoteException, ClassNotFoundException, IOException;

    public List<BloodReq> getallBloodReqs() throws RemoteException, ClassNotFoundException, IOException;

    public boolean deleteBloodReq(String name) throws RemoteException, ClassNotFoundException, IOException;
}
