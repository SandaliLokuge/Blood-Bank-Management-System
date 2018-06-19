package server.ijse.rmi.bloodbank.controllerImpl;

import common.ijse.rmi.bloodbank.controller.GuardianController;
import server.ijse.rmi.bloodbank.fileaccess.GuardianFileAccess;
import common.ijse.rmi.bloodbank.model.Guardian;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GuardianControllerImpl extends UnicastRemoteObject implements GuardianController {

    private GuardianFileAccess guardianFileAccess = new GuardianFileAccess();

    public GuardianControllerImpl() throws RemoteException {
    }

    public boolean addGuardian(Guardian guardian) throws RemoteException, ClassNotFoundException, IOException {
        return guardianFileAccess.addGuardian(guardian);
    }

    public Guardian searchGuardianByid(String guardianid) throws RemoteException, ClassNotFoundException, IOException {
        return guardianFileAccess.searchGuardianByid(guardianid);
    }

    public String getLastGuardianId() throws RemoteException, ClassNotFoundException, IOException {
        return guardianFileAccess.getLastId();
    }
}
