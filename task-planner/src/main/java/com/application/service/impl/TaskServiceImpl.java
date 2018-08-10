package com.application.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.application.beans.UserTaskDTO;
import com.application.entity.User;
import com.application.entity.UserTask;
import com.application.repositories.UserRepository;
import com.application.service.TaskService;
import com.application.util.ConfigurationUtility;
import com.application.util.DataEntityMapper;

/**
 * 
 * @author jokumar
 * @since 2018-03-25
 *
 *        Implementation class for different Task operation
 */

@Service
public class TaskServiceImpl implements TaskService {

	
	@Resource
	ConfigurationUtility utility;

	@Resource
	UserRepository userRepo;
	
	@Resource 
	DataEntityMapper mapper;

	// Retrieving all the Task associated to an User
	@Override
	public List<UserTaskDTO> retrieveTask() {
		List<UserTaskDTO> dtoList = new ArrayList<>();
		User user = userRepo.findOne(utility.getLoggedinUserName());
		//Retrieve all the task by userid 
		List<UserTask> taskList = user.getTaskList();
		for (UserTask task : taskList) {
			dtoList.add(mapper.userTaskMapper(task));
		}
		return dtoList;

	}
	// Retrieving all the Task associated to an User by Task Id

	@Override
	public UserTaskDTO retrieveTaskById(String taskId) {
		
		User user = userRepo.findOne(utility.getLoggedinUserName());
		// Retrieve all the task by user id and then filter by task id .
		List<UserTask> taskList = user.getTaskList().stream().filter((p -> p.getId() == Integer.valueOf(taskId)))
				.collect(Collectors.toList());
		UserTask userTask=new UserTask();
		if (taskList.size() > 0) {
			userTask= taskList.get(0);
		} 
		return mapper.userTaskMapper(userTask);
	}

	//Add a Task associated of an User 
	@Override
	public void addTask(UserTaskDTO dto) {
		UserTask userTask = mapper.userTaskConverter(dto);
		// Retrieve the user by userid
		User user = userRepo.findOne(utility.getLoggedinUserName());
		List<UserTask> list = user.getTaskList();
		userTask.setCreatedDate(new Date());// set the current date as created
											// date
		userTask.setUpdatedDate(new Date());// set the current date as updated
											// date
		list.add(userTask);// add a task to the existing task list
		user.setTaskList(list);
		userRepo.save(user);// Save the user with task details
	}

	// Update a task of an user
	public void updateTask(UserTaskDTO dto) {
		UserTask userTask=mapper.userTaskConverter(dto);
		User user = userRepo.findOne(utility.getLoggedinUserName());
		List<UserTask> list = user.getTaskList();
		//Update the task list with the new task .
		list.forEach(p-> {if(p.getId()==userTask.getId()){
			p.setDesc(userTask.getDesc());
			p.setDone(userTask.isDone());
			p.setName(userTask.getName());
			p.setTargetCompletion(userTask.getTargetCompletion());
			p.setTaskCategory(userTask.getTaskCategory());
			p.setUpdatedDate(new Date());
			
		}});
		userRepo.save(user);// save the user
		

	}

	// Delete a task of an user
	@Override
	public void deleteTask(String taskId) {
		User user = userRepo.findOne(utility.getLoggedinUserName());// retrieve the user by user id 
		user.getTaskList().removeIf(p -> p.getId() == Integer.valueOf(taskId));// remove the task id which matches from the list of tasks
		userRepo.save(user);//save the user
	}


}
