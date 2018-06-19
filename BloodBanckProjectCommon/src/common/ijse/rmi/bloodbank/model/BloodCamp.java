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
public class BloodCamp implements Serializable{
    private String place;
    private String date;
    private String time;
    private String contactnumber;
    private String contactperson;

    public BloodCamp() {
    }

    public BloodCamp(String place, String date, String time, String contactnumber, String contactperson) {
        this.place = place;
        this.date = date;
        this.time = time;
        this.contactnumber = contactnumber;
        this.contactperson = contactperson;
    }


    public String getPlace() {
        return place;
    }


    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getContactnumber() {
        return contactnumber;
    }


    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }


    public String getContactperson() {
        return contactperson;
    }


    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }
    
}
