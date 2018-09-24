package com.globomatics.bike.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

	@Autowired
	private BikeRepository bikeRepo;
	
	@GetMapping
	public List<Bike> getAllBikes() {
		return bikeRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Bike getOne(@PathVariable Long id) {
		return bikeRepo.getOne(id);	}
	
	@PostMapping("/create")
	public void create(@RequestBody Bike bike) {
		bikeRepo.save(bike);
	}
}
