package server.ijse.rmi.bloodbank.reserver;

import common.ijse.rmi.bloodbank.controller.BloodSampleController;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class BloodSampleReserver {

    public static Map<String, BloodSampleController> reserveData = new HashMap<>();

    public boolean reserveBloodSample(String id, BloodSampleController bloodSampleController) {
        if (reserveData.containsKey(id)) {
            if (reserveData.get(id) == bloodSampleController) {
                return true;
            } else {
                return false;
            }
        } else {
            reserveData.put(id, bloodSampleController);
            return true;
        }
    }

    public boolean releaseBloodSample(String id, BloodSampleController bloodSampleController) {
        if (reserveData.get(id) == bloodSampleController) {
            reserveData.remove(id);
            return true;
        } else {
            return false;

        }
    }
}
