package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientIntakeSystemApplicationTests {


	ClinicCalender cc = new ClinicCalender();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:a");
	PatientAppointment patient = new PatientAppointment("Rishikesh",sdf.format(new Date()));

	@Test
	public void addAppointments() {
		cc.addPatient(patient);
		assertEquals(1, cc.getList().size());
	}
	
	@Test
	public void dateFormatTest() {
		String date = sdf.format(new Date());
		assertEquals(date,patient.getDate());
	}
	
}
