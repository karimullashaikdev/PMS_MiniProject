package com.akhm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.entity.Task;
import com.akhm.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repo;

	public List<Task> getAllTasks() {
		return repo.findAll();
	}

	public Task saveTask(Task task) {
		return repo.save(task);
	}

	public void deleteTask(Long id) {
		repo.deleteById(id);
	}

	public Task findTask(Long id) {
		return repo.findById(id).get();
	}
}
