package com.vm.manager.university.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lector_departments", joinColumns = @JoinColumn(name = "department_id"), 
	inverseJoinColumns = @JoinColumn(name = "lector_id"))
	private List<Lector> lectors;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "department_head_id", nullable = false)
	private Lector departmentHead;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Lector> getLectors() {
		return lectors;
	}


	public void setLectors(List<Lector> lectors) {
		this.lectors = lectors;
	}


	public Lector getDepartmentHead() {
		return departmentHead;
	}


	public void setDepartmentHead(Lector departmentHead) {
		this.departmentHead = departmentHead;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
