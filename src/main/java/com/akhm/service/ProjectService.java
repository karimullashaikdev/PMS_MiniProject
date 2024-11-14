package com.akhm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.entity.Project;
import com.akhm.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repo;

	public List<Project> getAllProjects() {
		return repo.findAll();
	}

	public Project saveProject(Project project) {
		return repo.save(project);
	}

	public void deleteProject(Long id) {
		repo.deleteById(id);
	}

	public Project findProject(Long id) {
		return repo.findById(id).get();
	}
}
