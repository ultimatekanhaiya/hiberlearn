package com.map.manyToMany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int pid;

	@Column(name = "project_name")
	private String projcetName;

	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public Project() {
		super();
	}

	public Project(int pid, String projcetName, List<Employee> employees) {
		super();
		this.pid = pid;
		this.projcetName = projcetName;
		this.employees = employees;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjcetName() {
		return projcetName;
	}

	public void setProjcetName(String projcetName) {
		this.projcetName = projcetName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
