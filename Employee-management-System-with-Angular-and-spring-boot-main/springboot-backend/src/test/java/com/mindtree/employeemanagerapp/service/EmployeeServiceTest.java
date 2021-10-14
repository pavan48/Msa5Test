package com.mindtree.employeemanagerapp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;
import com.mindtree.employeemanagerapp.service.serviceimpl.EmployeeServiceImpl;

@SpringBootTest
class EmployeeServiceTest {
	@Autowired
	private EmployeeServiceImpl employeeService;
	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee=Employee.builder()
				.firstName("pavan")
				.lastName("Sai")
				.emailId("pavan@gmail.com")
				.build();
		
		
		Mockito.when(employeeRepository.findById(1L)).thenReturn(null);
		
	}

	
	@Test
	@DisplayName("Get data based on valid Employee Id")
	void testGetEmployeeById() {
	   long id=1;
	   Employee found=employeeService.getEmployeeById(id);
	   assertEquals(id,found.getId());
	   
	}

	
}
