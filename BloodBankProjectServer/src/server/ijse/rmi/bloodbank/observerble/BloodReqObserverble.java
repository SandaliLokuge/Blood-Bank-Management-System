/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.observerble;


import common.ijse.rmi.bloodbank.observer.BloodReqObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandali
 */
public class BloodReqObserverble {
        private String message;
    private static List<BloodReqObserver> observerList = new ArrayList<>();

    public void addBloodSampleObserver(BloodReqObserver bloodReqObserver) {
        observerList.add(bloodReqObserver);
    }

    public void removeBloodSampleObserver(BloodReqObserver bloodReqObserver) {
        observerList.remove(bloodReqObserver);
    }

    public void notifyBloodReqObserver() throws RemoteException {
        for (BloodReqObserver bloodReqObserver : observerList) {
            bloodReqObserver.Update(message);

        }
    }

    public void setMessage(String message) throws RemoteException {
        if (this.message != message) {
            this.message = message;
            notifyBloodReqObserver();

        }
    }
}
