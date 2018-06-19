package common.ijse.rmi.bloodbank.model;

import java.io.Serializable;

public class BloodSample implements Serializable{
	private String donorid;
	private String bloodbagid;
	private String donatedate;
	private String bloodgroup;
	private String donationtype;
	private String rhfactor;
	private String bodyweight;
	private String bodytemp;
	private String pulserate;
	private String bloodpressure;
	private String qty;
	private String testdate;
	private String reportno;
	private String hbsag;
	private String hiv;
	private String hcv;
	private String malariya;
	
	public BloodSample(){
		
	}
	
	public BloodSample(String donorid, String bloodbagid, String donatedate, String bloodgroup, String donationtype,String rhfactor, String bodyweight, String bodytemp, String pulserate, String bloodpressure,String qty, String testdate, String reportno, String hbsag,String hiv, String hcv, String malariya) {
        this.donorid = donorid;
        this.bloodbagid = bloodbagid;
        this.donatedate = donatedate;
        this.bloodgroup = bloodgroup;
        this.donationtype = donationtype;
        this.rhfactor = rhfactor;
        this.bodyweight = bodyweight;
        this.bodytemp = bodytemp;
        this.pulserate = pulserate;
        this.bloodpressure = bloodpressure;
        this.qty = qty;
        this.testdate = testdate;
        this.reportno = reportno;
        this.hbsag = hbsag;
        this.hiv = hiv;
        this.hcv = hcv;
        this.malariya = malariya;
    }
    
	public String getDonorid() {
        return donorid;
    }
    
    public void setDonorid(String donorid) {
        this.donorid = donorid;
    }
    
    public String getBloodbagid() {
        return bloodbagid;
    }
    
    public void setBloodbagid(String bloodbagid) {
        this.bloodbagid = bloodbagid;
    }
    
    public String getDonatedate() {
        return donatedate;
    }
    
    public void setDonatedate(String donatedate) {
        this.donatedate = donatedate;
    }
    
    public String getBloodgroup() {
        return bloodgroup;
    }
    
    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
    
    public String getDonationtype() {
        return donationtype;
    }
    
    public void setDonationtype(String donationtype) {
        this.donationtype = donationtype;
    }
    
    public String getRhfactor() {
        return rhfactor;
    }
    
    public void setRhfactor(String rhfactor) {
        this.rhfactor = rhfactor;
    }
    
    public String getBodyweight() {
        return bodyweight;
    }
    
    public void setBodyweight(String bodyweight) {
        this.bodyweight = bodyweight;
    }
    
    public String getBodytemp() {
        return bodytemp;
    }
    
    public void setBodytemp(String bodytemp) {
        this.bodytemp = bodytemp;
    }
    
    public String getPulserate() {
        return pulserate;
    }
    
    public void setPulserate(String pulserate) {
        this.pulserate = pulserate;
    }
    
    public String getBloodpressure() {
        return bloodpressure;
    }
    
    public void setBloodpressure(String bloodpressure) {
        this.bloodpressure = bloodpressure;
    }
    
    public String getQty() {
        return qty;
    }
    
    public void setQty(String qty) {
        this.qty = qty;
    }
    
    public String getTestdate() {
        return testdate;
    }
    
    public void setTestdate(String testdate) {
        this.testdate = testdate;
    }
    
    public String getReportno() {
        return reportno;
    }
    
    public void setReportno(String reportno) {
        this.reportno = reportno;
    }
    
    public String getHbsag() {
        return hbsag;
    }
    
    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }
    
    public String getHiv() {
        return hiv;
    }
    
    public void setHiv(String hiv) {
        this.hiv = hiv;
    }
    
    public String getHcv() {
        return hcv;
    }
    
    public void setHcv(String hcv) {
        this.hcv = hcv;
    }
    
    public String getMalariya() {
        return malariya;
    }
    
    public void setMalariya(String malariya) {
        this.malariya = malariya;
    }
}
