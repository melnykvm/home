package com.vm.manager.university.service;

import java.util.List;

import com.vm.manager.university.entity.Department;
import com.vm.manager.university.entity.Lector;
import com.vm.manager.university.util.Statistic;

public interface DepartmentService {
	
	List<Department> getAll();
	Lector getHeadOfDepartment(String departmentName);
	double getAverageSalary(String departmentName);
	int getEmployeeCount(String departmentName);
	Statistic getDepartmentStatistics(String departmentName);

}
