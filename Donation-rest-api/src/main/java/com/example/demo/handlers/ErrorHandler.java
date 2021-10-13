package com.example.demo.handlers;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandler {

	private LocalDateTime currentTime;
	private String message;
	private String description;
	
	

}
