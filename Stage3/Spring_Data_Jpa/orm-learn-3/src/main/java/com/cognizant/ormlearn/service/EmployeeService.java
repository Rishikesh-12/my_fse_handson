package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private final EmployeeRepository employeeRepository = null;

	@Transactional
	public Employee get(int id) {
		return employeeRepository.findById(id).get();
	}

	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Transactional
	public List<Employee> getAllPermanentEmployees() {
		return employeeRepository.getAllPermanentEmployees();
	}

//	@Transactional
//	public Double getAverageSalary() {
//		return employeeRepository.getAverageSalary();
//	}
	
	@Transactional
	public Double getAverageSalary(int id) {
		return employeeRepository.getAverageSalary(id);
	}
	
	@Transactional
	public List<Employee> getAllEmployeesNative(){
		return employeeRepository.getAllEmployeesNative();
	}
}
