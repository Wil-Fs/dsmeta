package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleReporsitory;

@Service
public class SalesServices {
	
	@Autowired
	private SaleReporsitory repository;
	
	public List<Sale> findSales(){
		return repository.findAll();
	}
}
