package common.ijse.rmi.bloodbank.model;

import java.io.Serializable;

public class Patient implements Serializable{
	private String patientid;
	private String title;
	private String firstname;
	private String lastname;
	private String gender;
	private String hospital;
	private String age;
	private String diseasedetail;
	
	
	public Patient(){
		
	}
	
	public Patient(String patientid,String title, String firstname, String lastname, String gender, String hospital,String age, String diseasedetail) {
        this.patientid = patientid;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.hospital = hospital;
        this.age = age;
        this.diseasedetail = diseasedetail;
        
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getPatientid() {
        return patientid;
    }
    
    public void setPatientid(String patientid) {
        this.patientid = patientid;
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
    
    public String getHospital() {
        return hospital;
    }
    
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    
    public String getAge() {
        return age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }
    
    public String getDiseasedetail() {
        return diseasedetail;
    }
    
    public void setDiseasedetail(String diseasedetail) {
        this.diseasedetail = diseasedetail;
    }
        
    
}
