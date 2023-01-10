package in.satheeshtech.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.satheeshtech.employeeapp.entity.Address;
import in.satheeshtech.employeeapp.entity.Employee;
import in.satheeshtech.employeeapp.response.EmployeeResponse;
import in.satheeshtech.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RestTemplate restTemplate;
	

	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
		// db call to employee/1
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);

		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
	
	@GetMapping("/employee-details")
	public ResponseEntity<List<Employee>> getAllAddress(){
		List<Employee> addressResponse1 = employeeService.getAllAddress();
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse1);
}

}
