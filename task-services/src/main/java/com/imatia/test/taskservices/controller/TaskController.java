package com.imatia.test.taskservices.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.imatia.test.taskservices.controller.exceptions.TaskNotFoundException;
import com.imatia.test.taskservices.model.Task;
import com.imatia.test.taskservices.service.TaskService;

@RestController
@RequestMapping(TaskController.REQUEST_MAPPING)
public class TaskController {
	public static final String REQUEST_MAPPING = "task";

	private static final UUID DEFAULT_UUID = UUID.fromString("da75a13a-aa95-11ec-b909-0242ac120002");

	@Autowired
	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}


	@GetMapping("/task")
	public Task task(){
		return new Task(findDefaultTask().getIdTask(), findDefaultTask().getName(), findDefaultTask().getCreationDate());
	}


	@GetMapping(value = "/default")
	@CrossOrigin(origins = "*")
	public Task findDefaultTask() {
		return taskService.findTaskById(DEFAULT_UUID).orElseThrow();
	}

	@ExceptionHandler(TaskNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No task was found")
	public void exceptionHandler() {

	}


	@GetMapping("/task/{id}")
	public ResponseEntity<Task> obtenerTareaPorId(@PathVariable UUID id) {

		Optional<Task> task = taskService.findTaskById(id);
		if (task.get() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(new Task(task.get().getIdTask(), task.get().getName(),task.get().getCreationDate()), HttpStatus.OK);
		}
	}


	@PostMapping("/crear")
	public ResponseEntity<Task> crearTarea(@RequestBody Task request) {

		taskService.createTask(request);

		return new ResponseEntity<>(request,HttpStatus.CREATED);

	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> eliminarUsuarioPorId(@PathVariable UUID id) {

		taskService.eliminarTarea(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}



}
