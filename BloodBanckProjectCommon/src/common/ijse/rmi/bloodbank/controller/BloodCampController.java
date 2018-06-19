/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.BloodSample;
import common.ijse.rmi.bloodbank.model.BloodCamp;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Sandali
 */
public interface BloodCampController extends Remote{
    public boolean addBloodCamp(BloodCamp bloodcamp) throws RemoteException, ClassNotFoundException, IOException;
    public List<BloodCamp> getallBloodCamps() throws RemoteException, ClassNotFoundException, IOException;
    public boolean deleteBloodCamp(String date) throws RemoteException, ClassNotFoundException, IOException;
    
}
