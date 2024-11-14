package com.akhm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "employe_id", referencedColumnName = "id"))
	private List<Employee> employees = new ArrayList<Employee>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_task", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"))
	private List<Task> tasks = new ArrayList<Task>();
}
