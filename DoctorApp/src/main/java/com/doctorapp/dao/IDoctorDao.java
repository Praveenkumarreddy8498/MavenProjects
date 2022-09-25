package com.doctorapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorDao {
	void addDoctor(Doctor doctor);

	boolean updateDoctor(int doctorId, double fees);

	Doctor findById(int doctorId);

	boolean deleteDoctor(int doctorId);

	List<Doctor> findAllDoctors();

	List<Doctor> findBySpeciality(String speciality);

	List<Doctor> findBySpecialityAndExp(String speciality, int experiance);

	List<Doctor> findBySpecialityAndFees(String speciality, double fees);

	List<Doctor> findByAvailability(LocalDateTime startTime);

}