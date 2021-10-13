package com.example.demo.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.DonationCamp;
import com.example.demo.data.Donor;

@Controller
public class BloodBankController {

	@Autowired
	private Donor obj1;
	@Autowired
	private DonationCamp obj2;
	@Autowired
	private ModelAndView mdlView;
	@Autowired
	private RestTemplate template;
	
	@RequestMapping(value="/")
	public String init(Model model) {
		model.addAttribute("majHeading","BLOOD DONATION CAMP");
		return "index";
	}
	@GetMapping(path="/addDonor")
	public String sendForm(Model model) {
		model.addAttribute("command",obj1);
		return "addDonor";
	}
	@ModelAttribute("bloodgroup")
	  public List<String> getExerciseList(){
	    List<String> bloodgroup = new ArrayList<>();
	    bloodgroup.add("A+");
	    bloodgroup.add("A-");
	    bloodgroup.add("B+");
	    bloodgroup.add("B-");
	    bloodgroup.add("O+");
	    bloodgroup.add("O-");
	    bloodgroup.add("AB+");
	    bloodgroup.add("AB-");
	    return bloodgroup;
	  }
	@PostMapping(path="/addDonor")
	public String submitForm(@Valid @ModelAttribute("command") Donor donor,BindingResult result) {
		//this.template.postForObject("http://localhost:7070/api/v1/students", student, Student.class);
		String nextStep="success";
		
		if(result.hasErrors()) {
			nextStep="addDonor";
		}
		else {
			HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Donor> requestBody=new HttpEntity<>(donor,headers);
			template.postForObject("http://localhost:1515/api/v1/donors", requestBody, Donor.class);
		}
		return nextStep;
	}
	@GetMapping(path = "/getAllDonors")
	public String findAll(Model model) {
	Donor[] resp =template.getForObject("http://localhost:1515/api/v1/donors",Donor[].class);
	model.addAttribute("data",resp);
	return "showDonors";

	}
	@GetMapping(path="/registerCamp")
	public String sendFormCamp(Model model) {
		model.addAttribute("command",obj2);
		return "registerCamp";
	}
	@PostMapping(path="/registerCamp")
	public String submitFormCamp(@Valid @ModelAttribute("command") DonationCamp donation,BindingResult result) {
		//this.template.postForObject("http://localhost:7070/api/v1/students", student, Student.class);
		String nextStep="success";
		
		if(result.hasErrors()) {
			nextStep="registerCamp";
		}
		else {
			HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<DonationCamp> requestBody=new HttpEntity<>(donation,headers);
			template.postForObject("http://localhost:1313/api/v1/donations", requestBody, DonationCamp.class);
		}
		return nextStep;
	}
	@GetMapping(path = "/getAllCampDetails")
	public String findAllCampDetails(Model model) {
	DonationCamp[] resp =template.getForObject("http://localhost:1313/api/v1/donations",DonationCamp[].class);
	model.addAttribute("details",resp);
	return "CampDetails";

	}
	@GetMapping(path = "/getBloodGroup")
	public String findByBloodGroup(Model model,String searchbybloodgroup) {
	Donor[] resp =template.getForObject("http://localhost:1515/api/v1/donors/searchbybloodgroup/"+searchbybloodgroup,Donor[].class);
	model.addAttribute("data",resp);
	return "showDonors";

	}
	@GetMapping(path = "/getByCity")
	public String findByCity(Model model,String searchbycity) {
	Donor[] resp =template.getForObject("http://localhost:1515/api/v1/donors/searchbycity/"+searchbycity,Donor[].class);
	model.addAttribute("data",resp);
	return "showDonors";

	}
	@GetMapping(path="/unregister")
	public String removeDonor(Model model,int value)
	{
	template.delete("http://localhost:1515/api/v1/donors/"+value,Donor[].class);
	return "deletesuccess";
	}
	@GetMapping(path = "/getByDate")
	public String findCamps(Model model,String searchbyDate) {
	DonationCamp[] resp =template.getForObject("http://localhost:1313/api/v1/donations/searchbydate/"+LocalDate.parse(searchbyDate),DonationCamp[].class);
	model.addAttribute("details",resp);
	return "CampDetails";

	}
//	
//	@PostMapping(path="/updateById")
//	public String updateDate(Model model,int id,String date) {
//		LocalDate lbd=LocalDate.parse(date);
//		template.getForObject("http://localhost:1515/api/v1/donors/"+lbd, Donor[].class);
//		return "updatesuccess";
//		
//	}
	@GetMapping(path="/updateById")
	public String updateDonor(Model model,int id, String updateDate)
	{
		//LocalDate lbd=LocalDate.parse(date);	
	template.put("http://localhost:1515/api/v1/donors/"+id+"/"+LocalDate.parse(updateDate),Donor[].class);
	return "updatesuccess";
	}
	
}
