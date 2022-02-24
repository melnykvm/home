package com.vm.manager.university;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vm.manager.university.entity.Lector;
import com.vm.manager.university.service.DepartmentService;
import com.vm.manager.university.service.LectorService;
import com.vm.manager.university.util.Statistic;

@Component
public class CommandLineLoop {

	private Scanner cmdInput;

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private LectorService lectorService;

	public static final String CMD_AVERAGE_SALARY = "Show the average salary for the department";
	public static final String CMD_EMPLOYEE_COUNT = "Show count of employee for";
	public static final String CMD_GLOBAL_SEARCH = "Global search by";
	public static final String CMD_DEPARTMENT_STATISTIC = "statistics";
	public static final String CMD_DEPARTMENT_HEAD = "Who is head of department"; 

	public CommandLineLoop() {
		this.cmdInput = new Scanner(System.in);
	}

	public void run() throws Exception {
		System.out.println("All Departments");
		departmentService.getAll().forEach(item -> System.out.print(item.getName() + ", "));
		System.out.println();
		System.out.println("Enter your command");
		
		
		String commandLine  = cmdInput.nextLine().trim();
		
		while (!commandLine.contains("exit")) {
			
			if (commandLine.indexOf(CMD_AVERAGE_SALARY) > -1) {
				String departmentName = getLastElement(commandLine);
				double averageSalary = departmentService.getAverageSalary(departmentName);
				
				System.out.printf("The average salary of %s is %.2f \n", departmentName, averageSalary);
			}
			
			if(commandLine.indexOf(CMD_EMPLOYEE_COUNT) > -1 ) {
				String departmentName = getLastElement(commandLine);
				int employeeCount = departmentService.getEmployeeCount(departmentName);
				
				System.out.println(employeeCount);
			}
			
			if(commandLine.indexOf(CMD_GLOBAL_SEARCH) > -1) {
				String searchTemplate = getLastElement(commandLine);
				List<Lector> lectorList = lectorService.globalSearch(searchTemplate);
				
				lectorList.forEach(item -> System.out.printf("%s %s, ", item.getSurName(), item.getName()));
			}
			
			if(commandLine.indexOf(CMD_DEPARTMENT_STATISTIC) > -1) {
				String departmentName = commandLine.split(" ")[1];
				Statistic departmentStatistic = departmentService.getDepartmentStatistics(departmentName);
				
				System.out.println("assistans - " + departmentStatistic.getAssistantCount());
				System.out.println("associate professors - " + departmentStatistic.getAssociateProfessorCount());
				System.out.println("professors - " + departmentStatistic.getProfessorCount());
			}
			
			if(commandLine.indexOf(CMD_DEPARTMENT_HEAD) > -1) {
				String departmentName = getLastElement(commandLine);
				Lector headOfDepartment = departmentService.getHeadOfDepartment(departmentName);
				
				System.out.printf("Head of %s department is %s ", departmentName, headOfDepartment.getName());
			}

			commandLine = cmdInput.nextLine();
		}
	}
	
	private String getLastElement(String command) {
		return Stream.of(command.split(" ")).reduce((first, last) -> last).get();
	}
}