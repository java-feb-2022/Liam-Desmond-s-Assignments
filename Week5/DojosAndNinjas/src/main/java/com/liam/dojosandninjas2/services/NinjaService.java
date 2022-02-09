package com.liam.dojosandninjas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.dojosandninjas2.models.Ninja;
import com.liam.dojosandninjas2.repositories.NinjaRepository;

@Service
public class NinjaService {

	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	
	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja getOne(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
	public Ninja createOne(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja updateOne(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public void deleteOne(Long id) {
		ninjaRepo.deleteById(id);
	}
}
