package com.apolo.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apolo.app.request.TinyUrlRequest;
import com.apolo.app.service.TinyUrlService;

@RestController
public class TinyUrlController {

	@Autowired
	private TinyUrlService service;
	
	@PostMapping("/tiny-url")
	public ResponseEntity<String> tinyUrl(@RequestBody TinyUrlRequest request){
		String tinyUrl= service.createTinyUrl(request);
		return new ResponseEntity<>(tinyUrl, HttpStatus.CREATED);
	}
	
	@GetMapping("/tiny-url/{tinyUrl}")
	public ResponseEntity<String> tinyUrl(@PathVariable("tinyUrl") String tinyUrl){
		String originalUrl= service.getOriginalUrl(tinyUrl);
		return new ResponseEntity<>(originalUrl, HttpStatus.OK);
	}
}
