package com.doctorapp.util;

public class Queries {
	public static final String INSERT_QUERY = "insert into doctors(doctorName,speciality,fees,experience,startTime,endTime) values(?,?,?,?,?,?)";
	public static final String UPDATE_QUERY = "update doctors set fees=? where doctorid=?";
	public static final String FINDBYID_QUERY = "select * from doctors where doctorid=?";
	public static final String DELETE_QUERY="delete from doctors  where doctorid=?";
	public static final String FIND_ALL_QUERY="select * from doctors";
	public static final String SPECIALITY_QUERY = "select * from doctors where speciality=?";
	public static final String SPECANDEXP_QUERY = "select * from doctors where speciality=? and experience>=?";
	public static final String SPECANDFEE_QUERY = "select * from doctors where speciality=? and fees<=?";
	public static final String AVAILABILITY_QUERY = "select * from doctors where startTime>=?";

}
