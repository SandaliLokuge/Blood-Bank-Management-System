package common.ijse.rmi.bloodbank.controller;

import common.ijse.rmi.bloodbank.model.Guardian;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GuardianController extends Remote {

    public boolean addGuardian(Guardian guardian) throws RemoteException, ClassNotFoundException, IOException;

    public Guardian searchGuardianByid(String guardianid) throws RemoteException, ClassNotFoundException, IOException;

    public String getLastGuardianId() throws RemoteException, ClassNotFoundException, IOException;
}
