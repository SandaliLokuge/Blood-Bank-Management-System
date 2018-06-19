package common.ijse.rmi.bloodbank.model;

import java.io.Serializable;

public class Guardian implements Serializable{
	private String guardianid;
	private String title;
	private String firstname;
	private String lastname;
	private String gender;
	private String nic;
	private String mobile;
	private String telhome;
	private String address;
	
	
	public Guardian(){
		
	}
	
	public Guardian(String guardianid,String title, String firstname, String lastname, String gender, String nic,String mobile, String telhome,String address) {
        this.guardianid = guardianid;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.nic = nic;
        this.mobile = mobile;
        this.telhome = telhome;
        this.address = address;
        
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getGuardianid() {
        return guardianid;
    }
    
    public void setGuardianid(String guardianid) {
        this.guardianid = guardianid;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getNic() {
        return nic;
    }
    
    public void setNic(String nic) {
        this.nic = nic;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getTelhome() {
        return telhome;
    }
    
    public void setTelhome(String telhome) {
        this.telhome = telhome;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }    
    
}

