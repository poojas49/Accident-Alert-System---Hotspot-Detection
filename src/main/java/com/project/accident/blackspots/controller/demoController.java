package com.project.accident.blackspots.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.accident.blackspots.model.demo;
import com.project.accident.blackspots.repository.DemoRepository;

@RestController
public class demoController {
	@Autowired
	private DemoRepository demoRepo;
	
	@GetMapping("/demo")
	public List<demo> getAllData(){
		return demoRepo.findAll();
	}
}
