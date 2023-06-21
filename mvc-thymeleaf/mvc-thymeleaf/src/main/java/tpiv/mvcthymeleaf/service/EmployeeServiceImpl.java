package tpiv.mvcthymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tpiv.mvcthymeleaf.dao.EmployeeRepository;
import tpiv.mvcthymeleaf.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> loadEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee loadEmployee(long id) {
//		return employeeRepository.findById(id).get();
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}
}
