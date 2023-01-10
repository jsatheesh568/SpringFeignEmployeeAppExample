package in.satheeshtech.employeeapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satheeshtech.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
