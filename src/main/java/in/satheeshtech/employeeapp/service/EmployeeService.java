package in.satheeshtech.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.satheeshtech.employeeapp.entity.Address;
import in.satheeshtech.employeeapp.entity.Employee;
import in.satheeshtech.employeeapp.feignclient.AddressClient;
import in.satheeshtech.employeeapp.repo.EmployeeRepository;
import in.satheeshtech.employeeapp.response.AddressResponse;
import in.satheeshtech.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressClient addressClient;

	
	public EmployeeResponse getEmployeeById(int id) {

		Employee employee = employeeRepository.findById(id).get();
		EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		// AddressResponse addressResponse = restTemplate.getForObject("/address/{id}",
		// AddressResponse.class, id);
		ResponseEntity<AddressResponse> addressResponseEntity = addressClient.getAddressByEmployeeId(id);/*
											 * webClient.get().uri("/address/" + id).retrieve()
											 * .bodyToMono(AddressResponse.class).block();
											 */
		AddressResponse addressResponse = addressResponseEntity.getBody();
		employeeResponse.setAddressResponse(addressResponse);
		// Employee -> EmployeeResponse

		/*
		 * EmployeeResponse employeeResponse = new EmployeeResponse();
		 * employeeResponse.setId(employee.getId());
		 * employeeResponse.setName(employee.getName());
		 * employeeResponse.setEmail(employee.getEmail());
		 * employeeResponse.setBloodGroup(employee.getBloodGroup());
		 */

		return employeeResponse;
	}
	
	public List<Employee> getAllAddress() {
		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}

}
