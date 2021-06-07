package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static void testGetEmployee(EmployeeService employeeService) {
		LOGGER.info("Start");
		Employee employee = employeeService.get(2);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testAddEmployee(EmployeeService employeeService, DepartmentService departmentService)
			throws ParseException {
		LOGGER.info("Start");
		Employee employee = new Employee();
		employee.setName("Rishikesh");
		employee.setSalary(12000);
		employee.setPermanent(true);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-18");
		employee.setDateOfBirth(date);
		Department department = departmentService.get(1);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.info("Added Successfully!");
		LOGGER.info("End");
	}

	private static void testUpdateEmployee(EmployeeService employeeService, DepartmentService departmentService) {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Department department = departmentService.get(4);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.info("Updated Successfully!");
		LOGGER.info("End");
	}

	private static void testGetDepartment(DepartmentService departmentService) {
		LOGGER.info("Start");
		Department department = departmentService.get(3);
		LOGGER.debug("Department: {}", department.getEmployeeList());
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee(EmployeeService employeeService, SkillService skillService) {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employeeService.save(employee);
		LOGGER.info("Skill Added Successfully!");
		LOGGER.info("End");
	}

	public static void testGetAllPermanentEmployees(EmployeeService employeeService) {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	
	public static void testGetAverageSalary(EmployeeService employeeService) {
		LOGGER.info("Start");
//		LOGGER.debug("Average Salary :{}", employeeService.getAverageSalary());
		LOGGER.debug("Average Salary of Department {} :{}",3,employeeService.getAverageSalary(3));
		LOGGER.info("End");
	}
	
	public static void testGetAllEmployeesNative(EmployeeService employeeService) {
		LOGGER.info("Start");
		LOGGER.debug("All :{}",employeeService.getAllEmployeesNative());
		LOGGER.info("End");
	}

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		DepartmentService departmentService = context.getBean(DepartmentService.class);
		SkillService skillService = context.getBean(SkillService.class);
//		testGetEmployee(employeeService);
//		testAddEmployee(employeeService,departmentService);
//		testUpdateEmployee(employeeService,departmentService);
//		testGetDepartment(departmentService);
//		testAddSkillToEmployee(employeeService, skillService);
		testGetAllPermanentEmployees(employeeService);
//		testGetAverageSalary(employeeService);
//		testGetAllEmployeesNative(employeeService);
	}

}
