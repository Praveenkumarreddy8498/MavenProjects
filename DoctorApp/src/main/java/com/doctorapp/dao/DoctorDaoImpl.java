package com.doctorapp.dao;

import java.sql.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.exception.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConnection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {

	@Override
	public void addDoctor(Doctor doctor) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.INSERT_QUERY);
			preparedstatement.setString(1, doctor.getDoctorName());
			preparedstatement.setString(2, doctor.getSpeciality());
			preparedstatement.setDouble(3, doctor.getFees());
			preparedstatement.setInt(4, doctor.getExperience());
			preparedstatement.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			preparedstatement.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));

			preparedstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public boolean updateDoctor(int doctorId, double fees) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		boolean result = true;
		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.UPDATE_QUERY);
			preparedstatement.setDouble(1, fees);
			preparedstatement.setInt(2, doctorId);
			int res = preparedstatement.executeUpdate();
			if (res == 0)
				result = false;

		} catch (SQLException | IdNotFoundException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	@Override
	public Doctor findById(int doctorId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Doctor doctor = new Doctor();

		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.FINDBYID_QUERY);
			preparedstatement.setInt(1, doctorId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				doctor.setDoctorName(resultset.getString(1));
				doctor.setDoctorId(resultset.getInt(2));
				doctor.setSpeciality(resultset.getString(3));
				doctor.setFees(resultset.getDouble(4));
				doctor.setExperience(resultset.getInt(5));
				doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return doctor;
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		boolean result = true;
		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.DELETE_QUERY);
			preparedstatement.setInt(1, doctorId);
			int res = preparedstatement.executeUpdate();
			if (res == 0) {
				result = false;
			}
		} catch (SQLException | IdNotFoundException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	@Override
	public List<Doctor> findAllDoctors() {
		List<Doctor> findalldoctors = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.FIND_ALL_QUERY);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorName(resultset.getString(1));
				doctor.setDoctorId(resultset.getInt(2));
				doctor.setSpeciality(resultset.getString(3));
				doctor.setFees(resultset.getDouble(4));
				doctor.setExperience(resultset.getInt(5));
				doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());

				findalldoctors.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return findalldoctors;
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		List<Doctor> doctorbyspeciality = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.SPECIALITY_QUERY);
			preparedstatement.setString(1, speciality);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorName(resultset.getString(1));
				doctor.setDoctorId(resultset.getInt(2));
				doctor.setSpeciality(resultset.getString(3));
				doctor.setFees(resultset.getDouble(4));
				doctor.setExperience(resultset.getInt(5));
				doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());

				doctorbyspeciality.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return doctorbyspeciality;
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experiance) {
		List<Doctor> doctorsAlongWithExp = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.SPECANDEXP_QUERY);
			preparedstatement.setString(1, speciality);
			preparedstatement.setInt(2, experiance);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorName(resultset.getString(1));
				doctor.setDoctorId(resultset.getInt(2));
				doctor.setSpeciality(resultset.getString(3));
				doctor.setFees(resultset.getDouble(4));
				doctor.setExperience(resultset.getInt(5));
				doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());

				doctorsAlongWithExp.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return doctorsAlongWithExp;
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> doctorsAlongWithFees = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.SPECANDFEE_QUERY);
			preparedstatement.setString(1, speciality);
			preparedstatement.setDouble(2, fees);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorName(resultset.getString(1));
				doctor.setDoctorId(resultset.getInt(2));
				doctor.setSpeciality(resultset.getString(3));
				doctor.setFees(resultset.getDouble(4));
				doctor.setExperience(resultset.getInt(5));
				doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());

				doctorsAlongWithFees.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return doctorsAlongWithFees;
	}

	@Override
	public List<Doctor> findByAvailability(LocalDateTime startTime) {
		List<Doctor> doctorsByAvailability = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			DbConnection.openConnection();
			connection = DbConnection.openConnection();
			preparedstatement = connection.prepareStatement(Queries.AVAILABILITY_QUERY);
			preparedstatement.setTimestamp(1, Timestamp.valueOf(startTime));
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {

				Doctor doctor = new Doctor();
				doctor.setDoctorName(resultset.getString(1));
				doctor.setDoctorId(resultset.getInt(2));
				doctor.setSpeciality(resultset.getString(3));
				doctor.setFees(resultset.getDouble(4));
				doctor.setExperience(resultset.getInt(5));
				doctor.setStartTime(resultset.getTimestamp(6).toLocalDateTime());
				doctor.setEndTime(resultset.getTimestamp(7).toLocalDateTime());

				doctorsByAvailability.add(doctor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
			try {
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return doctorsByAvailability;

	}

}
