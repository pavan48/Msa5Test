package com.mindtree.employeemanagerapp.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;
import com.mindtree.employeemanagerapp.service.EmployeeService;

import ch.qos.logback.core.status.Status;
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private EmployeeService employeeService;
	
	private Employee employee;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee=Employee.builder()
				.firstName("pavan")
				.lastName("Sai")
				.emailId("pavan@gmail.com")
				.build();
	}

	@Test
	void testCreateEmployee() {
		Employee inputEmployee=Employee.builder()
				.firstName("pavan")
				.lastName("Sai")
				.emailId("pavan@gmail.com")
				.build();
		
		Mockito.when(employeeService.createEmployee(inputEmployee)).thenReturn(employee);
		
		
		
		mockmvc.perform(MockMvcRequestBuilders.post(urlTemplate: "")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n"+
				"\t\"firstName(\"pavan\")\r\n"
				+ "lastName(\"Sai\")\r\n"
				+ ".emailId(\"pavan@gmail.com\")))"
				+ "}")
				.andExpect(MockMvcResultMatchers.status().isOk()));
		
	}

	@Test
	void testGetEmployeeById() {

		Mockito.when(employeeService.getEmployeeById(1L)).thenReturn(employee);
		
		
		
		mockmvc.perform(MockMvcRequestBuilders.post(urlTemplate: "/employee/1")
				.contentType(MediaType.APPLICATION_JSON)
				.andExpect(status().isOk())
				.andExpect(jsonPath(expression:"$.employeeId").value(employee.getId())));
		
	}

}
