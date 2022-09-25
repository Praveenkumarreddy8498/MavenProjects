package com.doctorapp.service;
import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exception.*;
import com.doctorapp.model.Doctor;

public interface IDoctorService {
	void addDoctor(Doctor doctor);
	
	void updateDoctor(int doctorId,double fees) throws IdNotFoundException;
	
	Doctor getById(int doctorId) throws IdNotFoundException;
	
	void deleteDoctor(int doctorId) throws IdNotFoundException;
	
	List<Doctor>getAllDoctors();
	
	List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;
	
	List<Doctor> getBySpecialityAndExp(String speciality,int experiance) throws DoctorNotFoundException;
	
	List<Doctor> getBySpecialityAndFees(String speciality,double fees) throws DoctorNotFoundException;
	
	List<Doctor> getByAvailability(LocalDateTime startTime) throws DoctorNotFoundException;


}