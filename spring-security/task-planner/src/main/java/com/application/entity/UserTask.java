package com.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author jokumar
 * @since 2018-03-25
 * 
 * User Task Entity Object
 */
@Entity
@Table(name = "TASK")
public class UserTask {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column(name="task_category")
	public String taskCategory;
	@Column(name="name")
	private String name;
	@Column(name="desc")
	private String desc;
	@Column(name="created_Date")
	private Date createdDate;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="target_completion")
	private Date targetCompletion;
	@Column(name="isDone")
	private boolean isDone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
