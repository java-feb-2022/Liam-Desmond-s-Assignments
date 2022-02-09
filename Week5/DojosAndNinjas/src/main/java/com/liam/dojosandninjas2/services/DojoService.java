package com.liam.dojosandninjas2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.dojosandninjas2.models.Dojo;
import com.liam.dojosandninjas2.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	
	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	public Dojo createOne(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo updateOne(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public void deleteOne(Long id) {
		dojoRepo.deleteById(id);
	}

}
