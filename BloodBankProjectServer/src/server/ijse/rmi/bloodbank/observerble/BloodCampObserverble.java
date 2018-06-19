/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.observerble;


import common.ijse.rmi.bloodbank.observer.BloodCampObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandali
 */
public class BloodCampObserverble {

    private String message;
    private static List<BloodCampObserver> observerList = new ArrayList<>();

    public void addBloodSampleObserver(BloodCampObserver bloodCampObserver) {
        observerList.add(bloodCampObserver);
    }

    public void removeBloodSampleObserver(BloodCampObserver bloodCampObserver) {
        observerList.remove(bloodCampObserver);
    }

    public void notifyBloodCampObserver() throws RemoteException {
        for (BloodCampObserver bloodCampObserver : observerList) {
            bloodCampObserver.Update(message);

        }
    }

    public void setMessage(String message) throws RemoteException {
        if (this.message != message) {
            this.message = message;
            notifyBloodCampObserver();

        }
    }
}
