package com.imatia.test.taskservices.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.imatia.test.taskservices.model.Task;
import com.imatia.test.taskservices.repository.TaskRepository;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Optional<Task> findTaskById(UUID uuid) {

		return taskRepository.findById(uuid);
	}


	public void createTask(Task task){

		 taskRepository.save(task);

		 System.out.println("tarea creada " + task.getIdTask());
	}

	public void eliminarTarea(UUID id) {
		
		taskRepository.deleteById(id);

		System.out.println("tarea eliminada ");

	}




	public ResponseEntity<Task> obtenerTarea(@PathVariable UUID id) {
		// Implementación para obtener una tarea por ID
	Task task = new Task();

		Task tareaDto = new Task();
		tareaDto.setIdTask(task.getIdTask());
		tareaDto.setName(task.getName());
		tareaDto.setCreationDate(task.getCreationDate());
		return null;
	}



}
