package com.manmohan.start.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manmohan.start.model.PatientScheduleModel;

@Repository
public interface PatientDao extends JpaRepository<PatientScheduleModel,String>{

	
}
