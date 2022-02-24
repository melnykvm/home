package com.vm.manager.university.service;

import java.util.List;

import com.vm.manager.university.entity.Lector;

public interface LectorService {

	List<Lector> getAll();
	List<Lector> globalSearch(String template);
}
