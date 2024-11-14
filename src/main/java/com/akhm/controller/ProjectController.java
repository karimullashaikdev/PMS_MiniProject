package com.akhm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhm.entity.Project;
import com.akhm.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService service;

	@GetMapping("/")
	public String homePage() {
		return "home";
	}

	@GetMapping("/getAllProjects")
	public String getAllProjects(Model model) {
		List<Project> projects = service.getAllProjects();
		model.addAttribute("projects", projects);
		return "projects";
	}

	@GetMapping("/addProject")
	public String addProject(Model model) {
		model.addAttribute("project", new Project());
		return "addproject";
	}

	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project project) {
		service.saveProject(project);
		return "redirect:/getAllProjects";
	}

	@GetMapping("/deleteProject/{id}")
	public String deleteProject(@PathVariable(value = "id") Long id, Model model) {
		service.deleteProject(id);
		return "redirect:/getAllProjects";
	}

	@GetMapping("/editProject/{id}")
	public String editProject(@PathVariable(value = "id") Long id, Model model) {
		Project project = service.findProject(id);
		model.addAttribute("project", project);
		return "editproject";
	}

	@PostMapping("/updateProject")
	public String updateProject(@ModelAttribute("project") Project project, Model model) {
		Project project2 = service.findProject(project.getId());
		project2.setName(project.getName());
		service.saveProject(project2);
		return "redirect:/getAllProjects";
	}
}
