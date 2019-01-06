package com.kdavies.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kdavies.todolist.model.Task;

/**
 * TaskRepository: an extension of the JpaRepository interface. 
 * @author Kathryn Davies
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}