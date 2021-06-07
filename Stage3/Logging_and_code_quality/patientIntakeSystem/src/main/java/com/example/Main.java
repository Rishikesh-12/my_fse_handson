package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static ClinicCalender cc = new ClinicCalender();
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		logger.info("Start");
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Patient Intake System");
		int option = 4;
		while (option != 3) {
			System.out.println("Please select an option");
			System.out.println("1  -  View All Appointments");
			System.out.println("2  -  Add patinent Appointments");
			System.out.println("3  -  Exit");
			option = sc.nextInt();
			if (option == 2)
				addPaitentAppointement();
			else if (option == 1)
				viewAllAppointments();
		}
		System.out.println("End");

	}

	private static void viewAllAppointments() {
		System.out.println("\nViewing all the appointments\n");
		List<PatientAppointment> appointments = cc.getList();
		if (appointments.size() > 0) {
			for (PatientAppointment p : appointments) {
				System.out.println(p);
			}
		} else {
			System.out.println("No appointments");
		}
		System.out.println("\n");

	}

	private static void addPaitentAppointement() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Patinet Name");
		String name = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:a");
		String date = sdf.format(new Date());
		PatientAppointment patient = new PatientAppointment(name, date);
		cc.addPatient(patient);
		System.out.println("\nAdded new Patient appointment\n");

	}

}
