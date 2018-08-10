package com.application.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author jokumar
 * @since 2018-03-25
 * 
 * User Entity Object
 */
@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name="user_id",unique=true,nullable=false)
	public String userId;
	@Column
	public String name;
	@Column
	public String password;
	//TODO Currently it holds single role
	@Column
	public String role;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	public List<UserTask> taskList;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<UserTask> getTaskList() {
		if(taskList==null){
			taskList=new ArrayList<UserTask>();
		}
		return taskList;
	}
	public void setTaskList(List<UserTask> taskList) {
		this.taskList = taskList;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
