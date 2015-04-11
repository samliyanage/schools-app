package com.sblsoft.schoolswebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sblsoft.schoolswebapp.model.School;
import com.sblsoft.schoolswebapp.service.Repository;

@RestController
public class SchoolController {
	
	@Autowired
	Repository<School> repository;
	
	private static final String API_CONTEXT = "/api/v1";

	@RequestMapping(value = API_CONTEXT+"/schools", method = RequestMethod.GET)
	public List<School> listAllSchools(Model model) {

		return repository.listObjects();
	}

	@RequestMapping(value = API_CONTEXT+"/school", method = RequestMethod.POST)
	public School addSchool(@RequestBody School school) {
		return repository.addObject(school);
	}

	@RequestMapping(value = API_CONTEXT+"/school/{id}", method = RequestMethod.GET)
	public School getSchoolById(@PathVariable("id") String id) {
		return repository.getObjectById(id);
	}

	@RequestMapping(value = API_CONTEXT+"/school/{id}", method = RequestMethod.PUT)
	public School updateSchool(@PathVariable("id") String id,
			@RequestBody School school) {

		return repository.updateObject(id, school);
	}

	@RequestMapping(value = API_CONTEXT+"/school/{id}", method = RequestMethod.DELETE)
	public void deleteSchool(@PathVariable("id") String id) {
		repository.deleteObject(id);
	}

}
