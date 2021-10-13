package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.DonationCamp;
import com.example.demo.repos.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository repo;
	
	public List<DonationCamp> findAll() {
		return this.repo.findAll();
	}
	public DonationCamp addDonation(DonationCamp entity) {
		return this.repo.save(entity);
	}
	public DonationCamp findById(Integer key) {
		return this.repo.findById(key).orElseThrow(()-> new RuntimeException("id not found"));
	}
public List<DonationCamp> findByCity(String loc) {
		
		return this.repo.findByCity(loc);
	}
public List<DonationCamp> findByCampDate(LocalDate date) {
	
	return this.repo.findByCampDate(date);
}
}
