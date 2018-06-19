package server.ijse.rmi.bloodbank.startmain;

import server.ijse.rmi.bloodbank.controllerImpl.RemoteFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;


public class ServerStart {
	public static void main(String[] args) {
        try {
            Registry bloodbankRegistry = LocateRegistry.createRegistry(5050);
            System.out.println("Server is starting....");
            bloodbankRegistry.rebind("BloodBankServer", new RemoteFactoryImpl());
        } catch (RemoteException ex) {
        }
    }
}


