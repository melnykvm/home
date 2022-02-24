package com.vm.manager.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vm.manager.university.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
	
	Department findByName(String name);
}
