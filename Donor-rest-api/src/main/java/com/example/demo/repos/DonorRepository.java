package com.example.demo.repos;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.Donor;


@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer>{
		
	
	
	public List<Donor> findByBloodGroup(String key);
	public List<Donor> findByCity(String loc);
	public boolean existsById(int id);
	public void deleteById(int id);

	@Query(nativeQuery = true,value="update donor set lastBloodDonationDate=:date where donorId=:number")
	@Modifying
	@Transactional
	public int updateDonationDate(@Param("number") int domainId,@Param("date") LocalDate lastBloodDonationDate);
	
//	@Query(nativeQuery = true,value="select * from donor a where DATADIFF(MONTH,a.lastBloodDonationDate,presentDate)>6")
//	@Modifying
//	@Transactional
//	public List<Donor> MonthsBetweenDates(LocalDate lastBloodDonationDate,LocalDate presentDate);
	
//
//	@Query(nativeQuery = true,value = "update donor set bloodGroup=:group where donorId=:number")
//	@Modifying
//	@Transactional
//	public int updateDonor(@Param("number") int domainId, @Param("group") String groupToUpdate);
}
