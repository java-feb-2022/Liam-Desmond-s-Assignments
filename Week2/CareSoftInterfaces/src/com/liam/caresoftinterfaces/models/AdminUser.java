package com.liam.caresoftinterfaces.models;

import java.util.ArrayList;
import java.util.Date;

import com.liam.caresoftinterfaces.interfaces.HIPAACompliantAdmin;
import com.liam.caresoftinterfaces.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	private String role;
    private ArrayList<String> securityIncidents;



	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();

	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		
		return securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin < 100000 || pin > 999999) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID == id) {
			return true;
		}
		authIncident();
		return false;
	}
	
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    
    

}
