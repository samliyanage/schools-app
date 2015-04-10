package com.sblsoft.schoolswebapp.service;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository<T> {
	
	public T addObject(T object);

	public T getObjectById(String id);

	public List<T> listObjects();

	public T updateObject(String id, T object);

	public void deleteObject(String id);
}
