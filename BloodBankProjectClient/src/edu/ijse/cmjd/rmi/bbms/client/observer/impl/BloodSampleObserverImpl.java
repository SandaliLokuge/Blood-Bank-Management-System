package edu.ijse.cmjd.rmi.bbms.client.observer.impl;

import edu.ijse.cmjd.rmi.bbms.client.view.IssueBloodSample;
import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;
import edu.ijse.cmjd.rmi.bbms.client.view.ViewBloodSamples;
import edu.ijse.cmjd.rmi.bbms.client.view.ViewDonationDetails;
import edu.ijse.cmjd.rmi.bbms.client.view.ViewDonors;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BloodSampleObserverImpl extends UnicastRemoteObject implements BloodSampleObserver {

    private ViewBloodSamples viewBloodSamples;
    private ViewDonors viewDonors;
    private IssueBloodSample issueBloodSample;
    private ViewDonationDetails viewDonationDetails;

    public BloodSampleObserverImpl(ViewBloodSamples viewBloodSamples) throws RemoteException {
        this.viewBloodSamples = viewBloodSamples;
    }

    public BloodSampleObserverImpl(ViewDonors viewDonors) throws RemoteException {
        this.viewDonors = viewDonors;
    }

    public BloodSampleObserverImpl(IssueBloodSample issueBloodSample) throws RemoteException {
        this.issueBloodSample = issueBloodSample;
    }

    public BloodSampleObserverImpl(ViewDonationDetails viewDonationDetails) throws RemoteException {
        this.viewDonationDetails = viewDonationDetails;
    }

    public void Update(String message) throws RemoteException {
        if (viewBloodSamples != null) {
            viewBloodSamples.setMessage(message);
        }
        if (viewDonors != null) {
            viewDonors.setMessage(message);
        }
        if (issueBloodSample != null) {
            issueBloodSample.setMessage(message);
        }
        if (viewDonationDetails != null) {
            viewDonationDetails.setMessage(message);
        }
    }
}
