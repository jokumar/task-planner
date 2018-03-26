package com.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.beans.UserTaskDTO;
import com.application.constant.CoreConstants;
import com.application.service.TaskService;
import com.application.util.ConfigurationUtility;

/**
 * 
 * @author jokumar
 * @since 2018-03-25
 * 
 * Controller class to handle various task related functionality .
 */

@Controller
public class TaskController {

	@Resource
	TaskService service;
	@Resource
	ConfigurationUtility utility;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	//List all the Task for a loggedIn User and forward to ListTask View 
	@GetMapping(value = "/list-task")
	public String showTodos(ModelMap model) {
		model.put(CoreConstants.TASK_OBJ, service.retrieveTask());
		return CoreConstants.LIST_TASK;
	}

	//Forward to AddTask view
	@GetMapping(value = "/add-task")
	public String showAddTodoPage(ModelMap model) {
		UserTaskDTO dto = new UserTaskDTO();
		dto.setTargetCompletion(new Date());
		model.addAttribute("task", dto);
		return CoreConstants.ADD_TASK;
	}

	//Add a Task for a Logged In User and forward to List Task View
	@PostMapping(value = "/add-task")
	public String addTask(ModelMap model, @Valid UserTaskDTO dto, BindingResult result) {
		if (result.hasErrors()) {
			return CoreConstants.ADD_TASK;//TODO It has to be handled as per requirement
		}

		service.addTask(dto);
		return CoreConstants.REDIRECT + CoreConstants.COLON + CoreConstants.FORWARD_SLASH + CoreConstants.LIST_TASK;
	}

	//Delete a Task for a Logged In User and forward to List Task View
	@GetMapping(value = "/delete-task/{taskId}")
	public String deleteTask(@PathVariable("taskId") String taskId) {
		service.deleteTask(taskId);
		return CoreConstants.REDIRECT + CoreConstants.COLON + CoreConstants.FORWARD_SLASH + CoreConstants.LIST_TASK;
	}

	//Forward to Update Task View
	@GetMapping(value = "/update-task")
	public String showUpdateTodoPage(@RequestParam("id") String taskId, ModelMap model) {
		UserTaskDTO dto = service.retrieveTaskById(taskId);
		model.put("task", dto);
		return CoreConstants.ADD_TASK;
	}

	//Update a Task for a Logged In User and forward to List Task View
	@PostMapping(value = "/update-task")
	public String updateTodo(ModelMap model, @Valid UserTaskDTO dto, BindingResult result) {

		if (result.hasErrors()) {
			return CoreConstants.ADD_TASK;//TODO It has to be handled as per requirement
		}
		
		service.updateTask(dto);

		return CoreConstants.REDIRECT + CoreConstants.COLON + CoreConstants.FORWARD_SLASH + CoreConstants.LIST_TASK;
	}
}
