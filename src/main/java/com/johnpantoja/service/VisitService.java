package com.johnpantoja.service;

import java.util.Optional;

import com.johnpantoja.entity.Visit;

public interface VisitService {


	
	public Iterable<Visit> getAllVisit();

	public Visit createVisit(Visit Visit) throws Exception;

	public Optional<Visit> getVisitById(Long id) throws Exception;
	
	public Visit updateVisit(Visit Visit) throws Exception;
	
	public void deleteVisit(Long id) throws Exception;
	







}
