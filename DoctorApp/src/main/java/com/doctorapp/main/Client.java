package com.doctorapp.main;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialisation;
import com.doctorapp.service.*;

public class Client {

	public static void main(String[] args) {
		IDoctorService doctorservice = new DoctorServiceImpl();
		Scanner sc = new Scanner(System.in);
		boolean select = true;
		while (select) {
			System.out.println("Enter the Choice\n" + "1.Add a Doctor \n" + "2.Update Doctor\n"
					+ "3.Find Doctor by Id\n" + "4.Delete Doctor by Id\n" + "5.Get All Doctors\n"
					+ "6.Get By Speciality \n" + "7.Get By Speciality and Experience\n"
					+ "8.Get By Speciality and Fees\n" + "9.Get By Availability \n");

			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: {
				System.out.println("Enter no of doctors to add ");
				int num = sc.nextInt();
				sc.nextLine();
				for (int i = 0; i < num; i++) {
					Doctor doctor = new Doctor();
					System.out.println("Enter DoctorName");
					String doctorName = sc.nextLine();
					doctor.setDoctorName(doctorName);

					System.out.println("Enter Speciality\n" + "0.Orthopedician\n" + "1.Pediatritian\n"
							+ "2.Diabetician\n" + "3.Cardiologist\n" + "4.General Physician\n");
					int type = sc.nextInt();
					sc.nextLine();
					String speciality = Specialisation.values()[type].type;
					doctor.setSpeciality(speciality);

					System.out.println("Enter Fees");
					double fees = sc.nextDouble();
					sc.nextLine();
					doctor.setFees(fees);

					System.out.println("Enter Experience");
					int experience = sc.nextInt();
					sc.nextLine();
					doctor.setExperience(experience);

					System.out.println("Enter Start Date,Time as  yyyy-MM-dd HH:mm  ");
					String startdatetime = sc.nextLine();
					DateTimeFormatter startdateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime startlocaldatetime = LocalDateTime.parse(startdatetime, startdateformat);
					doctor.setStartTime(startlocaldatetime);

					System.out.println("Enter End Date,Time  as  yyyy-MM-dd HH:mm ");
					String enddatetime = sc.nextLine();
					DateTimeFormatter enddateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime endlocaldatetime = LocalDateTime.parse(enddatetime, enddateformat);
					doctor.setEndTime(endlocaldatetime);

					doctorservice.addDoctor(doctor);
					System.out.println("Doctor Added");
					System.out.println();
				}
				break;

			}

			case 2: {
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("enter fees");
				double fees = sc.nextDouble();
				doctorservice.updateDoctor(id, fees);
				break;
			}
			case 3: {
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println(doctorservice.getById(id));
				break;
			}
			case 4: {
				System.out.println("Enter id");
				int id = sc.nextInt();
				doctorservice.deleteDoctor(id);
				break;
			}
			case 5: {
				doctorservice.getAllDoctors().forEach(System.out::println);

				break;
			}

			case 6: {
				System.out.println("Enter Speciality\n" + "0.Orthopedician\n" + "1.Pediatritian\n" + "2.Diabetician\n"
						+ "3.Cardiologist\n" + "4.General Physician\n");
				int type = sc.nextInt();
				String speciality = Specialisation.values()[type].type;// .toString();
				doctorservice.getBySpeciality(speciality).forEach(System.out::println);

				break;
			}
			case 7: {
				System.out.println("Enter Speciality\n" + "0.Orthopedician\n" + "1.Pediatritian\n" + "2.Diabetician\n"
						+ "3.Cardiologist\n" + "4.General Physician\n");
				int type = sc.nextInt();
				String speciality = Specialisation.values()[type].type;
				System.out.println("Enter Experience");
				int experience = sc.nextInt();

				doctorservice.getBySpecialityAndExp(speciality, experience).forEach(System.out::println);
				break;

			}
			case 8: {
				System.out.println("Enter Speciality\n" + "0.Orthopedician\n" + "1.Pediatritian\n" + "2.Diabetician\n"
						+ "3.Cardiologist\n" + "4.General Physician\n");
				int type = sc.nextInt();
				String speciality = Specialisation.values()[type].type;
				System.out.println("Enter Fees");
				double fees = sc.nextDouble();

				doctorservice.getBySpecialityAndFees(speciality, fees).forEach(System.out::println);
				break;

			}
			case 9: {
				System.out.println("Enter in Date,Time as  yyyy-MM-dd HH:mm  ");
				String startdatetime = sc.nextLine();
				DateTimeFormatter startdateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime startlocaldatetime = LocalDateTime.parse(startdatetime, startdateformat);

				doctorservice.getByAvailability(startlocaldatetime).forEach(System.out::println);
			}
			default: {
				System.out.println("invalid choice");
				break;
			}

			}
			System.out.println("\nEnter your choice\n" + "1.To Continue\n" + "2.To Exit\n");
			int choose = sc.nextInt();
			if (choose == 2)
				select = false;

		}
		sc.close();

	}

}
