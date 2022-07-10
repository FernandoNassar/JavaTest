package com.example.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException.FeignClientException;

@RestControllerAdvice
public class Handler {

	@ExceptionHandler(FeignClientException.class)
	public ResponseEntity<?> FeignClientExceptionHandler(FeignClientException e, HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível consultar o CEP informado");
	}
	
	@ExceptionHandler()
	public ResponseEntity<String> MethodArgumentNotValidHandler(MethodArgumentNotValidException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> RuntimeExceptionHandler(RuntimeException e, HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
	}
	
}
