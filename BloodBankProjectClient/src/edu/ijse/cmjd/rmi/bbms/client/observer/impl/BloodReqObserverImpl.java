/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.cmjd.rmi.bbms.client.observer.impl;

import edu.ijse.cmjd.rmi.bbms.client.view.Home;
import java.rmi.RemoteException;

/**
 *
 * @author Sandali
 */
public class BloodReqObserverImpl {

    private Home home;

    public BloodReqObserverImpl(Home home) throws RemoteException {
        this.home = home;
    }

    public void Update(String message) throws RemoteException {
        if (home != null) {
            home.setMessage(message);
        }
    }
}
