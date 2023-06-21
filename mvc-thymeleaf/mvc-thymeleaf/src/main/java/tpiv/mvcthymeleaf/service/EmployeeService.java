package tpiv.mvcthymeleaf.service;

import java.util.List;

import tpiv.mvcthymeleaf.entities.Employee;

public interface EmployeeService {
	List<Employee> loadEmployees();

	void save(Employee employee);

	Employee loadEmployee(long id);

	void delete(long id);
}
