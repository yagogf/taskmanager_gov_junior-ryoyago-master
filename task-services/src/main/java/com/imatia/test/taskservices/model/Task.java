package com.imatia.test.taskservices.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = 3224578592868604637L;

	@Id
	@GeneratedValue
	@Column(columnDefinition = "uuid NOT NULL DEFAULT random_uuid()")
	private UUID idTask;
	@Column(columnDefinition = "varchar(50) NOT NULL")
	private String name;
	@Column(columnDefinition = "timestamp NOT NULL default current_timestamp()")
	private Timestamp creationDate;

	public Task() {

	}

	public Task(UUID idTask, String name, Timestamp creationDate) {
		super();
		this.idTask = idTask;
		this.name = name;
		this.creationDate = creationDate;
	}

	public UUID getIdTask() {
		return idTask;
	}

	public void setIdTask(UUID idTask) {
		this.idTask = idTask;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

}
