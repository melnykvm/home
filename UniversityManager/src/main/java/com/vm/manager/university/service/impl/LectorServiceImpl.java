package com.vm.manager.university.service.impl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.manager.university.dao.LectorRepo;
import com.vm.manager.university.entity.Lector;
import com.vm.manager.university.service.LectorService;

/**
 * @author home
 *
 */
@Service
public class LectorServiceImpl implements LectorService {

	@Autowired
	private LectorRepo lectorRepo;
	
	@Override
	public List<Lector> getAll() {
		return lectorRepo.findAll();
	}

	
	@Override
	public List<Lector> globalSearch(String template) {
		List<Lector> lectors = lectorRepo.findAll();
		List<Lector> searchList = lectors.stream().filter(predicateName(template)
										.or(predicateSurName(template)))
										.collect(Collectors.toList());
		return searchList;
	}

	private Predicate<Lector> predicateName(String template){
		return item -> item.getName().contains(template);
	}
	
	private Predicate<Lector> predicateSurName(String template){
		return item -> item.getSurName().contains(template);
	}

}
