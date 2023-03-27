package com.imatia.test.taskservices.service;

import java.util.Optional;
import java.util.UUID;

import com.imatia.test.taskservices.model.Task;

public interface TaskService {

	Optional<Task> findTaskById(UUID uuid);

	void createTask(Task task);

	void eliminarTarea(UUID uuid);
}
