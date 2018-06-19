package server.ijse.rmi.bloodbank.observerble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import common.ijse.rmi.bloodbank.observer.DonorObserver;

public class DonorObserverble {

    private String message;
    private static List<DonorObserver> observerList = new ArrayList<>();

    public void addDonorObserver(DonorObserver donorObserver) {
        observerList.add(donorObserver);
    }

    public void removeDonorObserver(DonorObserver donorObserver) {
        observerList.remove(donorObserver);
    }

    public void notifyDonorObserver() throws RemoteException {
        for (DonorObserver donorObserver : observerList) {
            donorObserver.Update(message);

        }
    }

    public void setMessage(String message) throws RemoteException {
        if (this.message != message) {
            this.message = message;
            notifyDonorObserver();

        }
    }
}
