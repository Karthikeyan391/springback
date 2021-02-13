package com.tavant.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.restapi.exception.EmployeeNotFoundException;
import com.tavant.restapi.exception.NoDataFoundException;

import com.tavant.restapi.model.Employee;
import com.tavant.restapi.repository.EmployeeRepository;

@CrossOrigin(origins="http://localhost:3000")

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
@Autowired
EmployeeRepository employeeRepository;

@GetMapping
public String getEmployee() {
	return "welcome";
	
}
@GetMapping("/all")
public List<Employee> getAllEmployees() throws NoDataFoundException{
	if(employeeRepository.findAll().isEmpty())
	{
		throw new NoDataFoundException("no record found");
	}
	else {
		return employeeRepository.findAll();
	}
}
@GetMapping("/{id}")
public ResponseEntity<?> getEmployeeById(@PathVariable("id") Integer id) throws EmployeeNotFoundException{
	Optional<Employee> optional=employeeRepository.findById(id);
	if(optional.isPresent()) {
		return ResponseEntity.ok(optional.get());
	}
	else
	{
		throw new EmployeeNotFoundException("record not found");
		
		
	}
	
}

@PostMapping("/employee")
public Employee addEmployee(@RequestBody @Valid Employee employee) {
	return employeeRepository.save(employee);
}

@DeleteMapping("/{id}")
public Map<String, Boolean> deleteEmployees(@PathVariable(value = "id") Integer Id)
     throws EmployeeNotFoundException {
   Employee employee = employeeRepository.findById(Id)
   .orElseThrow(() -> new EmployeeNotFoundException("Account not found for this id :: " + Id));
    employeeRepository .delete(employee);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}


 @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer Id,
         @Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
      Employee employee1 = employeeRepository.findById(Id)
        .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for this id :: " +Id));
employee1.setFirstName(employee1.getFirstName());
employee1.setLastName(employee1.getLastName());
        final Employee updatedEmployee= employeeRepository.save(employee1);
        return ResponseEntity.ok(updatedEmployee);
    }

}
