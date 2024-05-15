package net.javaguides.ems_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empserv;
	
	
	@PostMapping("add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee)
	{
		return empserv.addEmployee(employee);
		
	}
	
	@GetMapping("allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		return empserv.getAllEmployees();
		
	}
	
	@GetMapping("employeeById/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return empserv.getEmployeeById(id);
    }
	
	@PutMapping("employeeUpdate")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		return empserv.updateEmployee(emp);
		
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
	{
		return empserv.deleteEmployee(id);
		
	}
	
}
