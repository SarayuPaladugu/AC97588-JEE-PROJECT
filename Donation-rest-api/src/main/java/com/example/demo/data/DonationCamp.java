package com.example.demo.data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="blooddonationcamp")
public class DonationCamp {

	@Id
	@Column(name="donorid")
	int donorId;
	@Column(name="city")
	String city;
	@Column(name="phonenumber")
	long phoneNumber;
	@Column(name="campdate")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate campDate;
	
}
