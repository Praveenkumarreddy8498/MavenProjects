package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import com.doctorapp.dao.*;
import com.doctorapp.exception.*;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService {
	IDoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public void addDoctor(Doctor doctor) {

		doctorDao.addDoctor(doctor);
	}

	@Override
	public void updateDoctor(int doctorId, double fees) throws IdNotFoundException {

		boolean result = doctorDao.updateDoctor(doctorId, fees);
		if (!result)
			throw new IdNotFoundException("Id Not Found");
		else
			System.out.println("Doctor with id " + doctorId + "is updated with fees" + fees);
	}

	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException {
		Doctor doctor = doctorDao.findById(doctorId);
		// Optional<Doctor> doctorById = Optional.of(doctorDao.findById(doctorId));
		// Doctor doctor1 = doctorById.stream().findFirst().orElseThrow(() -> new
		// IdNotFoundException("Id not Found"));

		if (doctor.getDoctorName() == null)
			throw new IdNotFoundException("Id not found");
		else
			return doctor;
	}

	@Override
	public void deleteDoctor(int doctorId) throws IdNotFoundException {
		boolean result = doctorDao.deleteDoctor(doctorId);
		if (!result)
			throw new IdNotFoundException("Id Not Found");
		else
			System.out.println("Doctor with Id " + doctorId + " is deleted");

	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctorList = doctorDao.findAllDoctors();
		if (doctorList.isEmpty()) {
			throw new DoctorNotFoundException();
		} else {
			doctorList.stream()
					.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareToIgnoreCase(doctor2.getDoctorName()))
					.collect(Collectors.toList());
			return doctorList;
		}

	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctorList = doctorDao.findBySpeciality(speciality);
		if (doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor Not Found");
		else {
			doctorList = doctorList.stream()
					.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareTo(doctor2.getDoctorName()))
					.collect(Collectors.toList());
			return doctorList;

		}

	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experiance) {
		List<Doctor> doctorList = doctorDao.findBySpecialityAndExp(speciality, experiance);
		if (doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor Not Found");
		else {
			doctorList = doctorList.stream()
					.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareTo(doctor2.getDoctorName()))
					.collect(Collectors.toList());
			return doctorList;
		}

	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		List<Doctor> doctorList = doctorDao.findBySpecialityAndFees(speciality, fees);
		if (doctorList.isEmpty())
			throw new DoctorNotFoundException();
		else {
			doctorList = doctorList.stream()
					.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareTo(doctor2.getDoctorName()))
					.collect(Collectors.toList());
		}

		return doctorList;
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime startTime) throws DoctorNotFoundException {
		List<Doctor> doctorList = doctorDao.findByAvailability(startTime);
		if (doctorList.isEmpty())
			throw new DoctorNotFoundException("Doctor Not Found");
		else {
			doctorList = doctorList.stream()
					.sorted((doctor1, doctor2) -> doctor1.getDoctorName().compareTo(doctor2.getDoctorName()))
					.collect(Collectors.toList());
			return doctorList;
		}

	}

}
