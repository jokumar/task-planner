package com.application.util;

import org.springframework.stereotype.Component;

import com.application.beans.UserTaskDTO;
import com.application.constant.CoreConstants;
import com.application.entity.UserTask;

@Component
public class DataEntityMapper {

	
	//Mapper to map the UserTask Entity to DTO . 
	public UserTaskDTO userTaskMapper(UserTask task) {
		UserTaskDTO taskDTO = new UserTaskDTO();
		taskDTO.setTaskId(task.getId());
		taskDTO.setDesc(task.getDesc());
		if (task.isDone()) {
			taskDTO.setDone(CoreConstants.TASK_STATUS_OPEN);
		} else {
			taskDTO.setDone(CoreConstants.TASK_STATUS_CLOSED);
		}
		taskDTO.setName(task.getName());
		taskDTO.setCreatedDate(task.getCreatedDate());
		taskDTO.setUpdatedDate(task.getUpdatedDate());
		taskDTO.setTargetCompletion(task.getTargetCompletion());
		taskDTO.setTaskCategory(task.getTaskCategory());
		return taskDTO;

	}

	//Mapper to map the UserTask DTO to UserTask Entity. 
	public UserTask userTaskConverter(UserTaskDTO dto) {
		UserTask task = new UserTask();
		task.setId(dto.getTaskId());
		task.setDesc(dto.getDesc());
		if (CoreConstants.TASK_STATUS_OPEN.equalsIgnoreCase(dto.getDone())) {
			task.setDone(true);
		} else {
			task.setDone(false);
		}
		task.setName(dto.getName());
		task.setCreatedDate(dto.getCreatedDate());
		task.setUpdatedDate(dto.getUpdatedDate());
		task.setTargetCompletion(dto.getTargetCompletion());
		task.setTaskCategory(dto.getTaskCategory());
		return task;

	}
}
