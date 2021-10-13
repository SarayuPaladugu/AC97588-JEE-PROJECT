package com.example.demo.handlers;

import java.time.LocalDateTime;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ErrorHandler handleAllException(Exception ex,WebRequest rq) {
		return new ErrorHandler(LocalDateTime.now(),ex.getMessage(),rq.getDescription(false));
	}
}
