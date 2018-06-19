/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.ijse.rmi.bloodbank.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sandali
 */
public interface BloodCampObserver extends Remote{
    public void Update(String message) throws RemoteException;
    
}
