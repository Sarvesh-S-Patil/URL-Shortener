package com.Sarvesh.SpringBootJPA.Service;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Sarvesh.SpringBootJPA.Entity.Url;
import com.Sarvesh.SpringBootJPA.Repository.UrlRepository;
@Service
public class UrlService {
	
	@Autowired
	UrlRepository urlRepository;
	@Autowired
	BaseConverter baseConverter;
	
	public String setLongUrl(Url LongUrl) {
		Url response = urlRepository.save(LongUrl);
		return baseConverter.longToString(response.getId());
	}
	
	public ResponseEntity<Void> getAndset(String urlReq){
		long id = baseConverter.StringToLong(urlReq);
		Url url = urlRepository.getReferenceById(id);
		URI uri = URI.create(url.getLongUrl());
		return ResponseEntity.status(HttpStatus.FOUND).location(uri).build();
	}

}
