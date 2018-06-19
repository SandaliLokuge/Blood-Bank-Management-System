package common.ijse.rmi.bloodbank.model;

import java.io.Serializable;

public class Issueblood implements Serializable {

    private String bloodbagid;
    private String donorid;
    private String patientid;
    private String guardianid;
    private String bloodgroup;
    private String rhfactor;
    private String qty;
    private String bloodcomponent;
    private String donatedate;
    private String issueddate;

    public Issueblood() {
    }

    public Issueblood(String bloodbagid, String donorid, String patientid, String guardianid, String bloodgroup, String rhfactor, String qty, String bloodcomponent, String donatedate, String issueddate) {
        this.bloodbagid = bloodbagid;
        this.donorid = donorid;
        this.patientid = patientid;
        this.guardianid = guardianid;
        this.bloodgroup = bloodgroup;
        this.rhfactor = rhfactor;
        this.qty = qty;
        this.bloodcomponent = bloodcomponent;
        this.donatedate = donatedate;
        this.issueddate = issueddate;

    }

    public String getBloodbagid() {
        return bloodbagid;
    }

    public void setBloodbagid(String bloodbagid) {
        this.bloodbagid = bloodbagid;
    }

    public String getDonorid() {
        return donorid;
    }

    public void setDonorid(String donorid) {
        this.donorid = donorid;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getGuardianid() {
        return guardianid;
    }

    public void setGuardianid(String guardianid) {
        this.guardianid = guardianid;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getRhfactor() {
        return rhfactor;
    }

    public void setRhfactor(String rhfactor) {
        this.rhfactor = rhfactor;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getBloodcomponent() {
        return bloodcomponent;
    }

    public void setBloodcomponent(String bloodcomponent) {
        this.bloodcomponent = bloodcomponent;
    }

    public String getDonatedate() {
        return donatedate;
    }

    public void setDonatedate(String donatedate) {
        this.donatedate = donatedate;
    }

    public String getIssueddate() {
        return issueddate;
    }

    public void setIssueddate(String issueddate) {
        this.issueddate = issueddate;
    }
}
