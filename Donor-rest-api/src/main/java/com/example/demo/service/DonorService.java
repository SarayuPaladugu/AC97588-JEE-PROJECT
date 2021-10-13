package com.example.demo.service;

import java.time.LocalDate;

import java.util.*;
import com.example.demo.data.*;
import com.example.demo.repos.DonorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DonorService {

	@Autowired
	private DonorRepository repo;
	
	public List<Donor> findAll() {
		return this.repo.findAll();
	}
	public Donor addDonor(Donor entity) {
		return this.repo.save(entity);
	}
	public Donor findById(Integer key) {
		return this.repo.findById(key).orElseThrow(()-> new RuntimeException("id not found"));
	}
	public List<Donor> findByBloodGroup(String key) {
		
		return this.repo.findByBloodGroup(key);
	}
	public List<Donor> findByCity(String loc) {
		
		return this.repo.findByCity(loc);
	}
	public int updateDonationDate(int donorId,LocalDate lastBloodDonationDate) {
		return this.repo.updateDonationDate(donorId, lastBloodDonationDate);
	}
	public int remove(int DonorId) {
		int rowDeleted=0;
		if(this.repo.existsById(DonorId)) {
			this.repo.deleteById(DonorId);
			rowDeleted=1;
		}
		return rowDeleted;
	}
//	public List<Donor> MonthsBetweenDates(LocalDate lastBloodDonationDate,LocalDate presentDate) {
//		return this.repo.MonthsBetweenDates(lastBloodDonationDate, presentDate);
//	}
}
