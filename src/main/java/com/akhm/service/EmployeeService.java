package com.akhm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.entity.Employee;
import com.akhm.entity.Task;
import com.akhm.repository.EmployeeRepository;
import com.akhm.repository.TaskRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}

	public Employee findEmployee(Long id) {
		return repo.findById(id).get();
	}
}
