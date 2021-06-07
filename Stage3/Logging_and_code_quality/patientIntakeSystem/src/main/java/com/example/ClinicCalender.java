package com.example;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClinicCalender {

	private List<PatientAppointment> list = new ArrayList<PatientAppointment>();
	

	public void addPatient(PatientAppointment patient) {
		// TODO Auto-generated method stub
		list.add(patient);
		for (PatientAppointment p:list) {
			System.out.println(p.toString());
		}

	}

}
