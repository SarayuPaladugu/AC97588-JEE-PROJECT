package com.example.demo.data;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name="donor")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Donor {

	@Id
	@Column(name="donorid")
	int donorId;
	@Column(name ="donorname")
	String donorName;
	@Column(name ="gender")
	String gender;
	@Column(name ="age")
	int age;
	@Column(name ="bloodgroup")
	String bloodGroup;
	@Column(name ="lastblooddonationdate")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate lastBloodDonationDate;
	@Column(name ="email")
	String email;
	@Column(name ="phonenumber")
	long phoneNumber;
	@Column(name ="state")
	String state;
	@Column(name ="city")
	String city;
	
	
}
