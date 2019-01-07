package com.kdavies.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resource Representation class for To-Do
 * List Items (Tasks).
 * Stores Task objects, annotated as JPA Entities.
 * Contains Task class with four attributes:
 * the id, the content, the completion status (isComplete),
 * and the priority.
 * 
 * @author Kathryn Davies
 *
 */
@Entity
@Table(name = "tasks")
public class Task {

	
	/**
	 * Task ID (Generated Value)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/**
	 * The content of the task
	 */
	private String content;
	
	/**
	 * Flag to indicate whether or not the task is complete
	 */
	private boolean isComplete;

	/**
	 * Default Constructor
	 */
	protected Task() {}

	/**
	 * Creates instances of Task to be saved to the database,
	 * with default value of isComplete = false
	 * @param content
	 */
	public Task(String content) {
		this.content = content;
		this.isComplete = false;
	}

	/**
	 * Getter for id
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter for id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter for content
	 * @return	content
	 */
	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	/**
	 * Setter for content
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter for isComplete
	 * @return	isComplete
	 */
	@Column(name = "is_complete", nullable = false)
	public boolean getIsComplete() {
		return isComplete;
	}

	/**
	 * Setter for isComplete
	 * @param isComplete
	 */
	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	/**
	 * Prints out the task's properties.
	 */
	@Override
	public String toString() {
		return "Task [id=" + id + ", content=" + content +
				", isComplete=" + isComplete + "]";
	}
}