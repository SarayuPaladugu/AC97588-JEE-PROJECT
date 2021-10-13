package com.example.demo.repos;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.DonationCamp;

@Repository
public interface DonationRepository extends JpaRepository<DonationCamp, Integer> {

//	@Query(nativeQuery = true,value="select * from blooddonationcamp where city=?")
	public List<DonationCamp> findByCity(String loc);
//	@Query(nativeQuery = true,value="select * from blooddonationcamp where campDate=?")
	public List<DonationCamp> findByCampDate(LocalDate date);
}
