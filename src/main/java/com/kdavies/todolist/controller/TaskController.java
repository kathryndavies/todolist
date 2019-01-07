package com.kdavies.todolist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kdavies.todolist.exceptions.ResourceNotFoundException;
import com.kdavies.todolist.model.Task;
import com.kdavies.todolist.repository.TaskRepository;

/**
 * Controller for the RESTful web service (handles
 * HTTP Requests)
 * 
 * @author Kathryn Davies
 *
 */
@RestController
@RequestMapping("/api/v1")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	/**
	 * Returns a list of Task objects from the repository.
	 * @return	list of tasks found in repository
	 */
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	/**
	 * Returns a specified task by ID
	 * @param taskId	the id of the requested task
	 * @return			the task with the specified ID
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long taskId)
			throws ResourceNotFoundException {

		Task task = taskRepository.findById(taskId).orElseThrow(() -> 
		new ResourceNotFoundException("No task found for the following id: " + taskId));

		return ResponseEntity.ok().body(task);
	}

	/**
	 * Creates a new task and saves to the repository
	 * @param task	the task to be created
	 * @return		the newly generated task resource
	 * 				that is saved to the repository
	 */
	@PostMapping("/tasks")
	public Task createTask(@Valid @RequestBody Task task) {
		return taskRepository.save(task);
	}

	/**
	 * Updates a specified task by ID
	 * @param taskId		id of task to be updated
	 * @param taskDetails	new details to set
	 * @return				updated task resource
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long taskId,
			@Valid @RequestBody Task taskDetails) throws ResourceNotFoundException {

		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("No task found for the following id: " + taskId));

		task.setContent(taskDetails.getContent());
		task.setIsComplete(taskDetails.getIsComplete());

		final Task updatedTask = taskRepository.save(task);

		return ResponseEntity.ok(updatedTask);
	}

	/**
	 * Deletes a specified task by ID
	 * @param taskId	id of task to be deleted
	 * @return			deletion status
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/tasks/{id}")
	public Map<String, Boolean> deleteTask(@PathVariable(value = "id") Long taskId)
			throws ResourceNotFoundException {

		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("No task found for the following id: " + taskId));

		taskRepository.delete(task);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	/**
	 * Deletes all tasks in the repository
	 * @return			deletion status
	 */
	@DeleteMapping("/tasks")
	public Map<String, Boolean> deleteAllTasks() {

		taskRepository.deleteAll();
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}