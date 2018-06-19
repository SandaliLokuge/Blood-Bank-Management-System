package edu.ijse.cmjd.rmi.bbms.client.observer.impl;

import edu.ijse.cmjd.rmi.bbms.client.view.IssueBloodSample;
import edu.ijse.cmjd.rmi.bbms.client.view.ViewBloodSamples;
import edu.ijse.cmjd.rmi.bbms.client.view.ViewIssuedBloodList;
import common.ijse.rmi.bloodbank.observer.IssuebloodObserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IssuebloodObserverImpl extends UnicastRemoteObject implements IssuebloodObserver {

    private ViewIssuedBloodList viewIssuedBloodList;
    private ViewBloodSamples viewBloodSamples;
    private IssueBloodSample issueBloodSample;

    public IssuebloodObserverImpl(ViewIssuedBloodList viewIssuedBloodList) throws RemoteException {
        this.viewIssuedBloodList = viewIssuedBloodList;
    }

    public IssuebloodObserverImpl(ViewBloodSamples viewBloodSamples) throws RemoteException {
        this.viewBloodSamples = viewBloodSamples;
    }

    public IssuebloodObserverImpl(IssueBloodSample issueBloodSample) throws RemoteException {
        this.issueBloodSample = issueBloodSample;
    }

    public void Update(String message) throws RemoteException {
        if (viewIssuedBloodList != null) {
            viewIssuedBloodList.setMessage(message);
        }
        if (viewBloodSamples != null) {
            viewBloodSamples.setMessage(message);
        }
        if (issueBloodSample != null) {
            issueBloodSample.setMessage(message);
        }
    }
}
