package com.vm.manager.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityManagerApplication implements CommandLineRunner{

	@Autowired
	private CommandLineLoop commandLineLoop;
	
	public static void main(String[] args) {
		SpringApplication.run(UniversityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandLineLoop.run();
	}

}
