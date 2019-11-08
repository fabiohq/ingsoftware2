package com.johnpantoja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnpantoja.entity.PointSale;
import com.johnpantoja.repository.PointSaleRepository;



@Service
public class PointSaleImpl implements PointSaleService {
	
	@Autowired
	PointSaleRepository repository;

	@Override
	public Iterable<PointSale> getAllPointSale() {
		// TODO Auto-generated method stub
		

		return repository.findAll();
	}

	@Override
	public PointSale createPointSale(PointSale pointSale) throws Exception {

		return repository.save(pointSale);
	}

	@Override
	public Optional<PointSale> getPointSaleById(Long id) throws Exception {
		
		return repository.findById(id);
	}

	@Override
	public PointSale updatePointSale(PointSale pointSale) throws Exception {
		

		return repository.save(pointSale);
	}

	@Override
	public void deletePointSale(Long id) throws Exception {
		repository.findById(id);

	}

	

}
