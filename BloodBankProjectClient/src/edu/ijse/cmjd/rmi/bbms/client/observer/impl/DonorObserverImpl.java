package edu.ijse.cmjd.rmi.bbms.client.observer.impl;

import common.ijse.rmi.bloodbank.observer.DonorObserver;
import edu.ijse.cmjd.rmi.bbms.client.view.ViewDonors;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DonorObserverImpl extends UnicastRemoteObject implements DonorObserver {

    private ViewDonors viewDonors;

    public DonorObserverImpl(ViewDonors viewDonors) throws RemoteException {
        this.viewDonors = viewDonors;
    }

    public void Update(String message) throws RemoteException {
        viewDonors.setMessage(message);
    }
}
