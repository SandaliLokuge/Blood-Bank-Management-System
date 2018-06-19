package server.ijse.rmi.bloodbank.observerble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import common.ijse.rmi.bloodbank.observer.BloodSampleObserver;

public class BloodSampleObserverble {

    private String message;
    private static List<BloodSampleObserver> observerList = new ArrayList<>();

    public void addBloodSampleObserver(BloodSampleObserver bloodSampleObserver) {
        observerList.add(bloodSampleObserver);
    }

    public void removeBloodSampleObserver(BloodSampleObserver bloodSampleObserver) {
        observerList.remove(bloodSampleObserver);
    }

    public void notifyBloodSampleObserver() throws RemoteException {
        for (BloodSampleObserver bloodSampleObserver : observerList) {
            bloodSampleObserver.Update(message);

        }
    }

    public void setMessage(String message) throws RemoteException {
        if (this.message != message) {
            this.message = message;
            notifyBloodSampleObserver();

        }
    }
}
