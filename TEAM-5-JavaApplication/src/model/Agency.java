/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Agency {
    
    // fields
    SimpleIntegerProperty agencyId;
    SimpleStringProperty address;
    SimpleStringProperty city;
    SimpleStringProperty province;
    SimpleStringProperty postal;
    SimpleStringProperty country;
    SimpleStringProperty phone;
    SimpleStringProperty fax;   
    
    public Agency(){}
    
    public Agency(int agencyId){
        this.agencyId = new SimpleIntegerProperty(agencyId);
    }
    
    // constructor
    public Agency(int agencyId, String address, String city, String province, 
            String postal, String country, String phone, String fax) 
    {
        this.agencyId = new SimpleIntegerProperty(agencyId);
        this.address = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.province = new SimpleStringProperty(province);
        this.postal = new SimpleStringProperty(postal);
        this.country = new SimpleStringProperty(country);
        this.phone = new SimpleStringProperty(phone);
        this.fax = new SimpleStringProperty(fax);
    }
    // getters and setters
    public int getAgencyId() {
        return agencyId.get();
    }

    public void setAgencyId(int agencyId) {
        this.agencyId.set(agencyId);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getProvince() {
        return province.get();
    }

    public void setProvince(String province) {
        this.province.set(province);
    }

    public String getPostal() {
        return postal.get();
    }

    public void setPostal(String postal) {
        this.postal.set(postal);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getFax() {
        return fax.get();
    }

    public void setFax(String fax) {
        this.fax.set(fax);
    }  
    
     // override method returns agentid
	@Override
	public String toString() {
		
		//return agentId.toString();
		return agencyId.get() + "";
	}
}
