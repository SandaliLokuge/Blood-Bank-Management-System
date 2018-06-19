/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.ijse.rmi.bloodbank.model;

import java.io.Serializable;

/**
 *
 * @author Sandali
 */
public class BloodReq implements Serializable{
   private String name;
   private String contactnum;
   private String bloodgroup;

    public BloodReq() {
    }

    public BloodReq(String name, String contactnum, String bloodgroup) {
        this.name = name;
        this.contactnum = contactnum;
        this.bloodgroup = bloodgroup;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }


    public String getBloodgroup() {
        return bloodgroup;
    }


    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
   
   
}
