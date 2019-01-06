package com.kdavies.todolist.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.kdavies.todolist.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TaskController taskController;

	@Test
	public void getTasks() throws Exception {

		List<Task> allTasks = taskController.getAllTasks();

		given(taskController.getAllTasks()).willReturn(allTasks);

		System.out.println(allTasks.size());

		mvc.perform(get("/api/v1/tasks/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
}