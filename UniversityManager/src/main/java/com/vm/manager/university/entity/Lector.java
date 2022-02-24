package com.vm.manager.university.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "lectors")
public class Lector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lector_id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surName;

	@Column(nullable = false)
	private double salary;
	
	@Column(nullable = false)
	private String degree;

	@ManyToMany(mappedBy = "lectors")
	private Set<Department> departments;
	
	@OneToOne(mappedBy = "departmentHead", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
	private Department department;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLector_id() {
		return lector_id;
	}

	public void setLector_id(Long lector_id) {
		this.lector_id = lector_id;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Lector [name=" + name + ", surName=" + surName + "]";
	}

}
