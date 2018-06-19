package common.ijse.rmi.bloodbank.model;

import java.io.Serializable;

public class Donor implements Serializable {

    private String donorid;
    private String title;
    private String firstname;
    private String lastname;
    private String regdate;
    private String gender;
    private String nic;
    private String telhome;
    private String mobile;
    private String address;
    private String dateofbirth;
    private String age;
    private String bloodgroup;
    private String rhfactor;

    public Donor() {
    }

    public Donor(String donorid, String title, String firstname, String lastname, String regdate, String gender, String nic, String telhome, String mobile, String address,String dateofbirth,String age,String bloodgroup, String rhfactor) {
        this.donorid = donorid;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.regdate = regdate;
        this.gender = gender;
        this.nic = nic;
        this.telhome = telhome;
        this.mobile = mobile;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.age = age;
        this.bloodgroup = bloodgroup;
        this.rhfactor = rhfactor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDonorid() {
        return donorid;
    }

    public void setDonorid(String donorid) {
        this.donorid = donorid;
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

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
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

    public String getTelhome() {
        return telhome;
    }

    public void setTelhome(String telhome) {
        this.telhome = telhome;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
}
