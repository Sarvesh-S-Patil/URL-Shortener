package com.Sarvesh.SpringBootJPA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Sarvesh.SpringBootJPA.Entity.Url;
import com.Sarvesh.SpringBootJPA.Service.UrlService;

@RestController
@RequestMapping("/urlshortner")
public class UrlController {
	@Autowired
	UrlService service;
	
	@RequestMapping("/test")
	public String test() {
		return "Test API Works";
	}
	
	@PostMapping("/shortenUrl")
	public String setLongUrl(@RequestBody Url LongUrl) {
		return service.setLongUrl(LongUrl);
	}
	
	@RequestMapping("/getLongUrl")
	public ResponseEntity<Void> getAndset(@RequestParam String urlReq){
		return service.getAndset(urlReq);
	}
}
