package com.kdavies.todolist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.kdavies.todolist.controller.TaskController;
import com.kdavies.todolist.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ToDoListApplicationTest {

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Autowired
	private TaskController controller;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		controller.deleteAllTasks();
		controller.createTask(new Task("task1"));
	}

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void shouldReturnJson() throws Exception {
		this.mockMvc.perform(get("/api/v1/tasks")).andDo(print()).andExpect(status()
				.isOk()).andExpect(content().contentType(CONTENT_TYPE));
	}

	@Test
	public void shouldCreateTask() throws Exception {
		this.controller.createTask(new Task("task2"));
		assertThat(controller.getAllTasks().size() == 2);
	}

	@Test
	public void shouldDeleteTasks() throws Exception {
		this.controller.deleteAllTasks();
		assertThat(controller.getAllTasks().size() == 0);
	}
}