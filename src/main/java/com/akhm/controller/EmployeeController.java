package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhm.entity.Employee;
import com.akhm.entity.Task;
import com.akhm.service.EmployeeService;
import com.akhm.service.TaskService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/getAllEmployees")
	public String getAllEmployees(Model model) {
		List<Employee> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employees";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addemployee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/getAllEmployees";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id, Model model) {
		service.deleteEmployee(id);
		return "redirect:/getAllEmployees";
	}

	@GetMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable(value = "id") Long id, Model model) {
		Employee employee = service.findEmployee(id);
		model.addAttribute("employee", employee);
		return "editemployee";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		Employee employee2 = service.findEmployee(employee.getId());
		employee2.setName(employee.getName());
		service.saveEmployee(employee2);
		return "redirect:/getAllEmployees";
	}
}
