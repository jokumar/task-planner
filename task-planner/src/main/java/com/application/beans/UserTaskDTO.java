package com.application.beans;

import java.util.Date;
/**
 * 
 * @author jokumar
 * @since 2018-03-25
 * DTO for User Tasks 
 */
public class UserTaskDTO {

	private int taskId;
	private String userId;
	private String taskCategory;
	private String name;
	private String desc;
	private Date createdDate;
	private Date updatedDate;
	private Date targetCompletion;
	private String done;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getTargetCompletion() {
		return targetCompletion;
	}

	public void setTargetCompletion(Date targetCompletion) {
		this.targetCompletion = targetCompletion;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}



}
