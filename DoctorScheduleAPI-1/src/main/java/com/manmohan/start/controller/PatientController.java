package com.manmohan.start.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.manmohan.start.model.PatientScheduleModel;
import com.manmohan.start.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	 private PatientService patientservice;
	
	public void setPatientService(PatientService es) {
		  this.patientservice = es;
		 }
	
	 //Get All Patients
	@GetMapping("/api/patients")
	 public List<PatientScheduleModel> getPatient() {
	  List<PatientScheduleModel> allpatient = patientservice.retriveAllPatientDetails();
	  return allpatient;
	 }
	 
	//Add New Patient
	 @PostMapping("/api/patients")
	 public String newPatientsDetail(PatientScheduleModel newpatient){
			
		 try {
			 LocalDate  date = LocalDate.now();
			 
			 date = patientservice.getAppointmentDate(date);
			 
			DayOfWeek dayOfWeek = DayOfWeek.from(date);
			
			if(dayOfWeek.getValue() == 7) 
			{
				date = date.plusDays(1);
			}  
			  
			newpatient.setAppointmentdate(date);
		   patientservice.newPatient(newpatient);
		   return("Patient Data is saved !");
		 }catch(Exception e)
		 {
			 return("Some Rules are voilated!\n"+e.getMessage());
		 }
			
		  
		 }
	 
	 //Delete patient
	 @DeleteMapping("/api/patients/{patientemail}&&{patientpassword}")
	 public String deletePatients(@PathVariable(name="patientemail")String patientemail, @PathVariable(name="patientpassword") String password){
	 
		 boolean check = patientservice.deletePatient(patientemail, password);
		 
		 if(check == true)
			 return("Data is successfully deleted!");
		 else
			 return("No such data exist in database!");
	  
	 }
	 
	 //Update patients
	 @PutMapping("/api/patients/{patients}&&{patientemail}&&{patientpassword}")
	 public String updatePatients(@RequestBody PatientScheduleModel patient,
			 @PathVariable(name="patientemail")String patientemail,
			 @PathVariable(name="patientpassword") String password){
		 
	 PatientScheduleModel p = patientservice.getPatient(patientemail, password);
	  if(p != null){
		  patientservice.updatePatient(patient);
		  return ("Data is updated");
	  }
	  else {
		  return ("Data is doesn't exist in database!");
	  }
	  
	 }
	 
	
}
