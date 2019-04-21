package com.manmohan.start.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;



@Entity
@Table(name="Patient")
public class PatientScheduleModel {

	@Pattern(regexp="^[A-Za-z]{3,}$") public String patientname;
	@Pattern(regexp="^[A-Za-z0-9'\\.\\-\\s\\,]{10,}$") public String patientaddress;
	@Id @Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])") public String patientemail;
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$") public String patientpasword;
	@Pattern(regexp="^\\d{2}$") public String countrycode;
	@Pattern(regexp="^\\d{10,}$") public String contactnumber;
	@OrderBy @ApiModelProperty(hidden=true) LocalDate appointmentdate;
	
	public LocalDate getAppointmentdate() {
		return appointmentdate;
	}
	
	public void setAppointmentdate(LocalDate date) {
		this.appointmentdate = date;
	}

	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPatientaddress() {
		return patientaddress;
	}
	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}
	public String getPatientemail() {
		return patientemail;
	}
	public void setPatientemail(String patientemail) {
		this.patientemail = patientemail;
	}
	public String getPatientpasword() {
		return patientpasword;
	}
	public void setPatientpasword(String patientpasword) {
		this.patientpasword = patientpasword;
	}
	
	
}
