package com.johnpantoja.service;

import java.util.Optional;

import com.johnpantoja.entity.PointSale;

public interface PointSaleService {


	
	public Iterable<PointSale> getAllPointSale();

	public PointSale createPointSale(PointSale pointSale) throws Exception;

	public Optional<PointSale> getPointSaleById(Long id) throws Exception;
	
	public PointSale updatePointSale(PointSale pointSale) throws Exception;
	
	public void deletePointSale(Long id) throws Exception;
	







}
