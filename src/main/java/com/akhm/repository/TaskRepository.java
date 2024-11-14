package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
