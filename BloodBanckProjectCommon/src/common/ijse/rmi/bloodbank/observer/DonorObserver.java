package common.ijse.rmi.bloodbank.observer;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DonorObserver extends Remote{
    public void Update(String message) throws RemoteException;
}
