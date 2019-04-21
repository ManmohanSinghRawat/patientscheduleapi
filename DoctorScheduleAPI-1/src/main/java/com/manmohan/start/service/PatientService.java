package com.manmohan.start.service;

import java.time.LocalDate;
import java.util.List;

import com.manmohan.start.model.PatientScheduleModel;

public interface PatientService {

	public List<PatientScheduleModel> retriveAllPatientDetails();

	
	public void newPatient(PatientScheduleModel newpatient);

	public boolean deletePatient(String patientemail, String password);


	public PatientScheduleModel getPatient(String patientemail, String password);


	public void updatePatient(PatientScheduleModel patient);


	public LocalDate getAppointmentDate(LocalDate date);

}
