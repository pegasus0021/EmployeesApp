package net.javaguides.ems_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.respository.EmployeeDAO;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO empdao;

	public ResponseEntity<String> addEmployee(Employee employee) {
		
		empdao.save(employee);
		
		try {
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		try {
			return new ResponseEntity<>(empdao.findAll(),HttpStatus.CREATED);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	 public Optional<Employee> getEmployeeById(Long id) {
	      return empdao.findById(id);
	    }

	public ResponseEntity<Employee> updateEmployee(Employee emp) {
		
		return new ResponseEntity<>(empdao.save(emp),HttpStatus.OK);
	}

	public ResponseEntity<String> deleteEmployee(Long id) {
		empdao.deleteById(id);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
