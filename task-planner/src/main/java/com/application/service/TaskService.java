package com.application.service;

import java.util.List;

import com.application.beans.UserTaskDTO;
import com.application.entity.UserTask;
/**
 * 
 * @author jokumar
 * @since   2018-03-25 
 *
 *	Interface for different Task operation
 */
public interface TaskService {
	
	//Retrieving all the Task associated to an User by Task Id
	public UserTaskDTO retrieveTaskById(String taskId);
	
	//Retrieving all the Task associated to an User
	public List<UserTaskDTO> retrieveTask();
	
	//Add a Task associated of an User 
	public void addTask(UserTaskDTO dto);
	
	//Update a task of an user
	public void updateTask(UserTaskDTO dto);
	
	//Delete a task of an user
	public void deleteTask(String taskId);
}
