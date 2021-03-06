package com.sblsoft.schoolswebapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sblsoft.schoolswebapp.model.School;

public class SchoolService implements com.sblsoft.schoolswebapp.service.Repository<School> {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "school";

	public School addObject(School school) {
		if (!mongoTemplate.collectionExists(School.class)) {
			mongoTemplate.createCollection(School.class);
		}
		String id=UUID.randomUUID().toString();
		school.setId(id);
		mongoTemplate.insert(school, COLLECTION_NAME);
		return getObjectById(id);
	}

	public School getObjectById(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
				School.class);
	}

	public List<School> listObjects() {
		return mongoTemplate.findAll(School.class, COLLECTION_NAME);
	}

	public School updateObject(String id, School school) {
		
		School schoolObject=getObjectById(id);
		
		if(school.getName()!=null && !"".equals(school.getName()) ){
			schoolObject.setName(school.getName());
		}
		
		if(school.getCode()!=null && !"".equals(school.getCode()) ){
			schoolObject.setCode(school.getCode());
		}
		
		if(school.getAddress()!=null && !"".equals(school.getAddress()) ){
			schoolObject.setAddress(school.getAddress());
		}
		
		if(school.getEmailDomain()!=null && !"".equals(school.getEmailDomain()) ){
			schoolObject.setEmailDomain(school.getEmailDomain());
		}
		mongoTemplate.save(schoolObject);
		
		return getObjectById(id);
	}

	public void deleteObject(String id) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)),
				School.class);
	}

}
