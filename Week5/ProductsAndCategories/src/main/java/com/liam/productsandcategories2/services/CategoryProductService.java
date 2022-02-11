package com.liam.productsandcategories2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.productsandcategories2.models.CategoryProduct;
import com.liam.productsandcategories2.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	
	@Autowired
	private CategoryProductRepository catproRepo;
	
	// Get All
				public List<CategoryProduct> getAll() {
					return catproRepo.findAll();
				}
				
				// Get One
				public CategoryProduct getOne(Long id) {
					return catproRepo.findById(id).orElse(null);
				}
				
				// Create
				public CategoryProduct createOne(CategoryProduct catpro) {
					return catproRepo.save(catpro);
				}
				
				
				// Update
				public CategoryProduct updateOne(CategoryProduct catpro) {
					return catproRepo.save(catpro);
				}
				
				// Delete
				public void deleteOne(Long id) {
					catproRepo.deleteById(id);
				}
				
				
				
				// Many to Many
				
				// Add -thing-
//				public void addExtra(User user, CategoryProduct car) {
//					
//					// Get array list of Users from main object
//					List<User> adders = car.getLikers();
//					
//					// Add User to list
//					adders.add(user);
//
//					carRepo.save(car);
//				}
//				
//				// Remove -thing-
//				public void removeExtra(User user, CategoryProduct car) {
//					
//					// Get array list of Users from main object
//					List<User> adders = car.getLikers();
//					
//					// Add User to list
//					adders.remove(user);
//
//					carRepo.save(car);
//				}

}
