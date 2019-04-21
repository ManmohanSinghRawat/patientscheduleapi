package com.manmohan.start.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manmohan.start.dao.PatientDao;
import com.manmohan.start.model.PatientScheduleModel;

@Service
public class PatientServiceImp implements PatientService {

	@Autowired
	 private PatientDao pdao;
	
	public void setEmployeeRepository(PatientDao pd) {
		  this.pdao = pd;
		 }
	
	@Override
	public List<PatientScheduleModel> retriveAllPatientDetails() {
		List<PatientScheduleModel> pat = pdao.findAll();
		  return pat;
	}

	@Override
	public void newPatient(PatientScheduleModel newpatient) {
		pdao.save(newpatient);		
	}

	@Override
	public boolean deletePatient(String patientemail, String password) {
		try {
			Optional<PatientScheduleModel> optP = pdao.findById(patientemail);
			PatientScheduleModel p = optP.get();
			
			if(p.getPatientpasword().equals(password))
				{	pdao.deleteById(patientemail);
					return true;
				}
				else {
					return false;
				}
			
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public PatientScheduleModel getPatient(String patientemail, String password) {
		try {
			Optional<PatientScheduleModel> optP = pdao.findById(patientemail);
			PatientScheduleModel p = optP.get();
			if(p.getPatientpasword().equals(password))
					return optP.get();
				else
					return null;
			
		}catch(Exception e) {
			return null;
		}
		  
	}

	@Override
	public void updatePatient(PatientScheduleModel patient) {
		
		pdao.save(patient);
		
	}

	@Override
	public LocalDate getAppointmentDate(LocalDate date) {
		
		List<PatientScheduleModel> pat = pdao.findAll();
		Iterator<PatientScheduleModel> ite = pat.iterator();
		PatientScheduleModel p;
		LocalDate d;
		int countdate = 1;
		
		while(ite.hasNext())
		{
			p = ite.next();
			d = p.getAppointmentdate();
			
			if(d.isAfter(date))
			{
				date = d;
				countdate = 2;
			}
			else {
				if(d.isEqual(date))
				{
					countdate++;
				}
			}
			
		}
		
		if(countdate > 50)
		{
			date = date.plusDays(1);
		}
		
	
		return date;
	
	}

}
