package net.javaguides.ems_backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.ems_backend.entity.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long>{
	
}
