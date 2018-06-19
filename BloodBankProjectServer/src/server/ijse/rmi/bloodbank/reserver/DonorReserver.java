package server.ijse.rmi.bloodbank.reserver;

import common.ijse.rmi.bloodbank.controller.DonorController;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class DonorReserver {

    public static Map<String, DonorController> reserveData = new HashMap<>();

    public boolean reserveDonor(String id, DonorController donorController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == donorController) {
                return true;
            } else {
                return false;
            }
        } else {
            reserveData.put(id, donorController);
            return true;
        }
    }

    public boolean releaseDonor(String id, DonorController donorController) {
        if (reserveData.get(id) == donorController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;

        }
    }
}
