package com.vm.manager.university.util;


public class Statistic {
	private long assistantCount;
	private long professorCount;
	private long associateProfessorCount;
	
	public Statistic(long assistantCount, long professorCount, long associateProfessorCount) {
		this.assistantCount = assistantCount;
		this.professorCount = professorCount;
		this.associateProfessorCount = associateProfessorCount;
	}

	public long getAssistantCount() {
		return assistantCount;
	}

	public long getProfessorCount() {
		return professorCount;
	}

	public long getAssociateProfessorCount() {
		return associateProfessorCount;
	}
	
	
}
