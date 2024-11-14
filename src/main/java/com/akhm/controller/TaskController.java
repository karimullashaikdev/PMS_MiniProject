package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhm.entity.Task;
import com.akhm.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService service;

	@GetMapping("/getAllTasks")
	public String getAllTasks(Model model) {
		List<Task> tasks = service.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "tasks";
	}

	@GetMapping("/addTask")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "addtask";
	}

	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Task task) {
		service.saveTask(task);
		return "redirect:/getAllTasks";
	}

	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable(value = "id") Long id, Model model) {
		service.deleteTask(id);
		return "redirect:/getAllTasks";
	}

	@GetMapping("/editTask/{id}")
	public String editTask(@PathVariable(value = "id") Long id, Model model) {
		Task task = service.findTask(id);
		model.addAttribute("task", task);
		return "edittask";
	}

	@PostMapping("/updateTask")
	public String updateTask(@ModelAttribute("task") Task task, Model model) {
		Task task2 = service.findTask(task.getId());
		task2.setName(task.getName());
		service.saveTask(task2);
		return "redirect:/getAllTasks";
	}
}
