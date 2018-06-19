/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.ijse.rmi.bloodbank.reserver;

import common.ijse.rmi.bloodbank.controller.BloodReqController;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sandali
 */
public class BloodReqReserver {

    public static Map<String, BloodReqController> reserveData = new HashMap<>();

    public boolean reserveBloodReq(String name, BloodReqController bloodReqController) {
        if (reserveData.containsKey(name)) {
            if (reserveData.get(name) == bloodReqController) {
                return true;
            } else {
                return false;
            }
        } else {
            reserveData.put(name, bloodReqController);
            return true;
        }
    }

    public boolean releaseBloodReq(String name, BloodReqController bloodReqController) {
        if (reserveData.get(name) == bloodReqController) {
            reserveData.remove(name);
            return true;
        } else {
            return false;

        }
    }
}
