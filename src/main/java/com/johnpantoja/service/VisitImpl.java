package com.johnpantoja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnpantoja.entity.Visit;
import com.johnpantoja.repository.VisitRepository;





@Service
public class VisitImpl implements VisitService {
	
	@Autowired
	VisitRepository repository;

	@Override
	public Iterable<Visit> getAllVisit() {
		// TODO Auto-generated method stub
		
	
		return repository.findAll();
	}

	@Override
	public Visit createVisit(Visit Visit) throws Exception {

		return repository.save(Visit);
	}

	@Override
	public Optional<Visit> getVisitById(Long id) throws Exception {
		
		return repository.findById(id);
	}

	@Override
	public Visit updateVisit(Visit Visit) throws Exception {
		

		return repository.save(Visit);
	}

	@Override
	public void deleteVisit(Long id) throws Exception {
		repository.findById(id);

	}

	

}
