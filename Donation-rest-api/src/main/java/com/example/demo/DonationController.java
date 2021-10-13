package com.example.demo;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.DonationCamp;

import com.example.demo.service.DonationService;


@RequestMapping(path = "/api/v1/donations")
@RestController
public class DonationController {

	@Autowired
	private DonationService service;
	public void setService(DonationService service) {
		this.service = service;
	}
	@PostMapping
	public ResponseEntity<DonationCamp> addDonation(@RequestBody DonationCamp entity) {
		DonationCamp addedEntity=this.service.addDonation(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	@GetMapping 
	public List<DonationCamp> findAll() {
		
		return this.service.findAll();
		
	}
	
	@GetMapping(path = "/{donorId}")
	public DonationCamp findById(@PathVariable("donorId")int DonorId) {
		
		return this.service.findById(DonorId);
		
	}
	@GetMapping(path = "/searchcampbycity/{city}")
	public List<DonationCamp> findByCity(@PathVariable("city")String city) {
		
		return this.service.findByCity(city);
		
	}

	@GetMapping(path = "/searchbydate/{campDate}")
	public List<DonationCamp> findByCampDate(@PathVariable("campDate")String campDate) {
		
		return this.service.findByCampDate(LocalDate.parse(campDate));
		
	}

}

