package com.vm.manager.university.service.impl;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.manager.university.dao.DepartmentRepo;
import com.vm.manager.university.entity.Department;
import com.vm.manager.university.entity.Lector;
import com.vm.manager.university.service.DepartmentService;
import com.vm.manager.university.util.Degree;
import com.vm.manager.university.util.Statistic;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	
	private Predicate<Lector> predicateAssistant = item -> item.getDegree().compareTo(Degree.ASSISTANT) > 0 ;
	private Predicate<Lector> predicateProfessor = item -> item.getDegree().compareTo(Degree.PROFESSOR) > 0 ;
	private Predicate<Lector> predicateAssociateProfessor = item -> item.getDegree().compareTo(Degree.ASSOCIATE_PROFESSOR) > 0 ;
	
	@Override
	public List<Department> getAll() {
		return departmentRepo.findAll();
	}

	/**
	 * 
	 */
	@Override
	public double getAverageSalary(String departmentName) {
		Department department = departmentRepo.findByName(departmentName);
		List<Lector> lectors = department.getLectors();

		DoubleSummaryStatistics statistic = lectors.stream()
											.collect(Collectors.summarizingDouble(Lector::getSalary));
		return statistic.getAverage();
	}

	@Override
	public int getEmployeeCount(String departmentName) {
		Department department = departmentRepo.findByName(departmentName);
		return department.getLectors().size();
	}

	@Override
	public Statistic getDepartmentStatistics(String departmentName) {
		Department department = departmentRepo.findByName(departmentName);
		List<Lector> lectors = department.getLectors();
		
		long assistantCount = lectors.stream().filter(predicateAssistant).count();
		long professorCount = lectors.stream().filter(predicateProfessor).count();
		long associateProfessorCount = lectors.stream().filter(predicateAssociateProfessor).count();
		
		return new Statistic(assistantCount, professorCount, associateProfessorCount);
	}

	@Override
	public Lector getHeadOfDepartment(String departmentName) {
		Department department = departmentRepo.findByName(departmentName);
		Lector headOfDepartment = department.getDepartmentHead();
		return headOfDepartment;
	}
	
}
